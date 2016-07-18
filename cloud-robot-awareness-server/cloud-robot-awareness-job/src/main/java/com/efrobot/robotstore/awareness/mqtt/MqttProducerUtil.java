package com.efrobot.robotstore.awareness.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import com.efrobot.robotstore.awareness.util.MacSignature;
import com.efrobot.robotstore.awareness.util.ProducerResourceUtil;

public class MqttProducerUtil {

	private MqttClient sampleClient = null;

	private MqttConnectOptions connOpts = null;

	private String[] topicFilters = null;

	private String topic = null;

	private MqttProducerUtil() {
		createMqttConnction();
	}

	private static class InstanceClass {
		private final static MqttProducerUtil instances = new MqttProducerUtil();

	}

	public static MqttProducerUtil getInstance() {
		return InstanceClass.instances;
	}

	public MqttConnectOptions getConnOpts() {
		return connOpts;
	}

	public String[] getTopicFilters() {
		return topicFilters;
	}

	public MqttClient getSampleClient() {
		return sampleClient;
	}

	private final void createMqttConnction() {

		final String broker = ProducerResourceUtil.getInstance().getPropertiesValue("broker");
		final String acessKey = ProducerResourceUtil.getInstance().getPropertiesValue("AccessKey");
		final String secretKey = ProducerResourceUtil.getInstance().getPropertiesValue("SecretKey");
		topic = ProducerResourceUtil.getInstance().getPropertiesValue("Topic");
		final String clientId = ProducerResourceUtil.getInstance().getPropertiesValue("ProducerId");

		MemoryPersistence persistence = new MemoryPersistence();

		try {

			sampleClient = new MqttClient(broker, clientId, persistence);
			connOpts = new MqttConnectOptions();
			System.out.println("Connecting to broker: " + broker);

			String sign = MacSignature.macSignature(clientId, secretKey);
			connOpts.setUserName(acessKey);
			connOpts.setServerURIs(new String[] { broker });
			connOpts.setPassword(sign.toCharArray());
			connOpts.setCleanSession(false);
			connOpts.setKeepAliveInterval(100);
			connOpts.setConnectionTimeout(10000);
			sampleClient.connect(connOpts);
			//System.out.println("subscribe....success");

		} catch (Exception me) {
			me.printStackTrace();
		}

	}

	public final void publishMessage(String deviceId, String scontent) {
		final MqttMessage message = new MqttMessage(scontent.getBytes());
		message.setQos(1);
		// message.setRetained(false);
		try {
			final String clientId = ProducerResourceUtil.getInstance().getPropertiesValue("ConsumerId");
			sampleClient.publish(topic + "/p2p/" + clientId + "@@@" + deviceId, message);
		} catch (MqttPersistenceException e) {
			e.printStackTrace();
		} catch (MqttException e) {
			e.printStackTrace();
		} finally {
			if (null != sampleClient) {
				// try {
				// /// sampleClient.close();
				// } catch (MqttException e) {
				// e.printStackTrace();
				// }
			}
		}

	}
	
	static public void main(String[] args) {
		
		
		MqttProducerUtil mqttProducerUtil=MqttProducerUtil.getInstance();
	///	while (true) {
			mqttProducerUtil.publishMessage("12345678", "jkfdfdfdfdfd");
			
	///	}
		
		
	}
	
	
	
}
