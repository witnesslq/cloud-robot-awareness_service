package com.efrobot.robotstore.awareness.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

import com.efrobot.toolkit.util.security.MD5;

public final class StringParserUtil {

	public static final java.util.Map<String, String> parserContext(String context) {
		Map<String, String> map = new HashMap<String, String>();
		String sessionParamer = new String(Base64.decodeBase64(context));
		String[] array = sessionParamer.split(",");

		for (String strs : array) {
			int lastIndexof = strs.lastIndexOf("=");
			String key = strs.substring(0, lastIndexof);
			String value = strs.substring(lastIndexof + 1);
			map.put(key, value);
		}

		return map;
	}
	
	public static final String getIpInfo() {
		String resultIp = null;
		InetAddress addr = null;
		try {
			addr = InetAddress.getLocalHost();
			String ip = addr.getHostAddress().toString();// 获得本机IP
			resultIp = MD5.getInstance().getMD5String(ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return resultIp;
	}

}
