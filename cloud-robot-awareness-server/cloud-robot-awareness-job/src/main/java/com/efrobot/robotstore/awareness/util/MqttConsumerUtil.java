package com.efrobot.robotstore.awareness.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttConsumerUtil {

	private MqttClient sampleClient = null;

	private MqttConnectOptions connOpts = null;

	private String[] topicFilters = null;

	private MqttConsumerUtil() {

	}

	private static class InstanceClass {
		private final static MqttConsumerUtil instances = new MqttConsumerUtil();

	}

	public static MqttConsumerUtil getInstance() {
		return InstanceClass.instances;
	}

	public MqttConnectOptions getConnOpts() {
		return connOpts;
	}

	public String[] getTopicFilters() {
		return topicFilters;
	}

	public final MqttClient createMqttConnction() {

		final String broker = ResourceUtil.getInstance().getPropertiesValue("broker");
		final String acessKey = ResourceUtil.getInstance().getPropertiesValue("AccessKey");
		final String secretKey = ResourceUtil.getInstance().getPropertiesValue("SecretKey");
		final String topic = ResourceUtil.getInstance().getPropertiesValue("Topic");

		topicFilters = new String[] { topic + "/p2p/" };
		final String clientId = ResourceUtil.getInstance().getPropertiesValue("ConsumerId");

		MemoryPersistence persistence = new MemoryPersistence();

		try {
			sampleClient = new MqttClient(broker, clientId, persistence);
		} catch (MqttException e) {
			e.printStackTrace();
		}
		connOpts = new MqttConnectOptions();

		System.out.println("Connecting to broker: " + broker);

		String sign = null;
		try {
			sign = MacSignature.macSignature(clientId.split("@@@")[0], secretKey);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		connOpts.setUserName(acessKey);
		connOpts.setServerURIs(new String[] { broker });
		connOpts.setPassword(sign.toCharArray());

		connOpts.setCleanSession(false);
		connOpts.setKeepAliveInterval(2000);
		connOpts.setConnectionTimeout(30000);

		return sampleClient;
	}

	public final void connect() {

		try {
			sampleClient.connect(connOpts);
			sampleClient.subscribe(topicFilters);
			//System.out.println("subscribe....success");
		} catch (MqttSecurityException e) {
			e.printStackTrace();
		} catch (MqttException e) {
			e.printStackTrace();
		}
		System.out.println("Connecting to broker:00000 ");

	}

}
