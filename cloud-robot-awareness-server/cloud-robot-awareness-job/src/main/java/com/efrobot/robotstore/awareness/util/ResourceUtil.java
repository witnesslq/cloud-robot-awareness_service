package com.efrobot.robotstore.awareness.util;

import java.io.IOException;
import java.util.Properties;

public final class ResourceUtil {

	private Properties properties = new Properties();

	private static final class ClassInstance {

		private static final ResourceUtil instance = new ResourceUtil();

	}

	private ResourceUtil() {
		try {
			properties.load(ResourceUtil.class.getClassLoader().getResourceAsStream("consumer.properties"));
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

	public static ResourceUtil getInstance() {
		return ClassInstance.instance;
	}

}
