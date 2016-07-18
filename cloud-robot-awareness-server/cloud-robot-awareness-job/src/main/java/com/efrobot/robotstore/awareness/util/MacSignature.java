package com.efrobot.robotstore.awareness.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MacSignature {
    /**
     * @param text      Ҫǩ�����ı�
     * @param secretKey ������MQ secretKey
     * @return ���ܺ���ַ���
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     */
    public static String macSignature(String text, String secretKey) throws InvalidKeyException, NoSuchAlgorithmException {
        Charset charset = Charset.forName("UTF-8");
        String algorithm = "HmacSHA1";
        Mac mac = Mac.getInstance(algorithm);
        mac.init(new SecretKeySpec(secretKey.getBytes(charset), algorithm));
        byte[] bytes = mac.doFinal(text.getBytes(charset));
        return new String(Base64.encodeBase64(bytes), charset);
    }

    /**
     * ���ͷ�ǩ������
     *
     * @param clientId  Mqtt ClientId
     * @param secretKey ������MQ secretKey
     * @return ���ܺ���ַ���
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public static String publishSignature(String clientId, String secretKey) throws NoSuchAlgorithmException, InvalidKeyException {
        return macSignature(clientId, secretKey);
    }

    /**
     * ���ķ�ǩ������
     *
     * @param topics    Ҫ���ĵ�Topic����
     * @param clientId  Mqtt ClientId
     * @param secretKey ������MQ secretKey
     * @return ���ܺ���ַ���
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public static String subSignature(List<String> topics, String clientId, String secretKey) throws NoSuchAlgorithmException, InvalidKeyException {
        Collections.sort(topics); //���ֵ�˳������
        String topicText = "";
        for (String topic : topics) {
            topicText += topic + "\n";
        }
        String text = topicText + clientId;
        return macSignature(text, secretKey);
    }

    /**
     * ���ķ�ǩ������
     *
     * @param topic     Ҫ���ĵ�Topic
     * @param clientId  Mqtt ClientId
     * @param secretKey ������MQ secretKey
     * @return ���ܺ���ַ���
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public static String subSignature(String topic, String clientId, String secretKey) throws NoSuchAlgorithmException, InvalidKeyException {
        List<String> topics = new ArrayList<String>();
        topics.add(topic);
        return subSignature(topics, clientId, secretKey);
    }
}
