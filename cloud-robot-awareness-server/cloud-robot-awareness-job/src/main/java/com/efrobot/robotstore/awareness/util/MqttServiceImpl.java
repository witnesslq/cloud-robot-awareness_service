/**
 * 
 */
package com.efrobot.robotstore.awareness.util;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




public class MqttServiceImpl  {

	private ExecutorService fixedThreadPool = null;

	MqttServiceImpl() {
		fixedThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*2);
	}

	public void startMqtt() {

		final MqttConsumerUtil mqttConsumerUtil = MqttConsumerUtil.getInstance();

		final MqttClient mqttClient = mqttConsumerUtil.createMqttConnction();
		mqttClient.setCallback(new MqttCallback() {

			public void connectionLost(Throwable throwable) {

				System.out.println("connectionLost");

				try {
					mqttClient.connect(mqttConsumerUtil.getConnOpts());
					mqttClient.subscribe(mqttConsumerUtil.getTopicFilters());
				} catch (MqttSecurityException e) {
					e.printStackTrace();
				} catch (MqttException e) {
					e.printStackTrace();
				}

			}

			public void messageArrived(String topic, MqttMessage mqttMessage) {

				byte[] msg = mqttMessage.getPayload();
				
				try {
					System.out.println("messageArrived:" + new String (msg,"utf-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			
			}

			public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
				System.out.println("deliveryComplete:" + iMqttDeliveryToken.getMessageId());
			}

		});

		mqttConsumerUtil.connect();
	}
	
	
	static public void main(String[] args) {
		
		MqttServiceImpl  mqttServiceImpl=new MqttServiceImpl();
		mqttServiceImpl.startMqtt();
	}

}
