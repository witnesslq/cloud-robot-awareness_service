package com.efrobot.robotstore.awareness.util;

import java.io.IOException;
import java.util.Properties;

public final class ProducerResourceUtil {

	private Properties properties = new Properties();

	private static final class ClassInstance {

		private static final ProducerResourceUtil instance = new ProducerResourceUtil();

	}

	private ProducerResourceUtil() {
		try {
			properties.load(ProducerResourceUtil.class.getClassLoader().getResourceAsStream("producer.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getPropertiesValue(String key) {
		if (null != key && properties.containsKey(key)) {
			return properties.getProperty(key);
		}
		return null;
	}

	public static ProducerResourceUtil getInstance() {
		return ClassInstance.instance;
	}

}
