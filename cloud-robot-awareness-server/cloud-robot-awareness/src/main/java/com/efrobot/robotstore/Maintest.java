package com.efrobot.robotstore;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.efrobot.toolkit.util.http.RestClient;
import com.efrobot.toolkit.util.security.MD5;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.AutoPopulatingList;
public class Maintest {
	private static RestTemplate restTemplate = new RestTemplate();
	
	
	
	public static byte[] decode(String str) {  
	     byte[] bt = null;  
	     try {  
	     sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();  
	     bt = decoder.decodeBuffer(str);  
	     } catch (Exception e) {  
	     e.printStackTrace();  
	     }  
	      
	     return bt;  
	     }  

	
	
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
	
	
	
	public static void main(String[] args) {
		
		JSONObject ret_Context_=new JSONObject(true);
		ret_Context_.put("actionTime", "19:24");
		ret_Context_.put("beginTime", "2016-07-09");
		ret_Context_.put("endTime", "2016-07-11");
		
		JSONObject ret_Context=new JSONObject(true);
		ret_Context.put("serviceType", "09620");
		ret_Context.put("content", ret_Context_);
		System.out.print(ret_Context);
//		
//		String str="Y3Zlcj01LjAuMjQuMTEyNix3YXBfcHJveHk9d2lmaSxST0JPVF9YSUFPUEFOR19JRD0xMjM0NTY3ODkwMTIsYWFwPS9zdG9yYWdlL2VtdWxhdGVkLzAvbXNjL3N1ZC53YXYsbGFuZ3VhZ2U9emhfY24sZW9zPTEwMDAsdmFkX3NwZWVjaF90YWlsPTEwMDAsbXNjX21hYz13bGFuMDo2NDphNjo1MTplYTozZjo4MixhdWRpb19mb3JtYXQ9d2F2LHB0dD0xLG5ldF90eXBlPXdpZmksYWNjZW50PW1hbmRhcmluLHZhZF9lbmFibGU9dHJ1ZSxhdWY9YXVkaW8vTDE2O3JhdGU9MTYwMDAsY2xpZW50X2lwPTEyMy4xMjUuMTM5LjE3MCxzYW1wbGVfcmF0ZT0xNjAwMCxzdGltZT0yMDE2LzA2LzIyLG5scF92ZXJzaW9uPTIuMCxhdWU9c3BlZXgtd2IsbmV0X3N1YnR5cGU9bm9uZSxlbnQ9c21zMTZrLHZhZF90aW1lb3V0PTQwMDAsc3ViPWlhdCx0dGU9dXRmLTgscnN0PWpzb24sZG9tYWluPWlhdCxyc2U9dXRmLTgsY3VhPTEsc2VydmVyXzNfdXJsPWh0dHA6Ly8xMDEuMjAwLjIyMS40Mzo4MDgyL3YxL3NlcnZlci9mb3JtL2dldElmbHl0ZWtTZXJ2ZXIsc2NoPTEsbXNjLnNraW49MCxhZGRjYXA9a2Nsb3Vk";
//		
//		java.util.Map<String, String> map=Maintest.parserContext(str);
//
//		System.out.println("......"+map.get("ROBOT_XIAOPANG_ID"));
//		
//		JSONObject  jsonContext=new JSONObject(true);
//		jsonContext.put("Type", "text");
//		jsonContext.put("ContentType", "Json");
//		jsonContext.put("Content", "张杰");
//		
//		JSONObject  json=new JSONObject(true);
//		json.put("MsgId", 1234567);
//		json.put("CreateTime", 1348831860);
//		json.put("AppId", "508627e4");
//		json.put("UserId", "d123455");
//		
//		json.put("SessionParams", "Y21kPXNzYixzdWI9aWF0LHBsYXRmb3JtPWFuZG9yaWQ");
//		json.put("UserParams", "PG5hbWU+eGlhb2JpYW5iaWFuPC9uYW1lPg==");
//		
//		json.put("FromSub", "iat");
//		
//		json.put("Msg", jsonContext);
//		
//		json.put("Res", "[]");
////		
////		
////		
////		///String url="http://101.200.221.43:8082/v1/server/form/getServer";
//        String url = "http://localhost:8080/cloud-robot-webapp/v1/server/form/getIflytekServer";
    ///  String url="http://101.200.221.43:8082/v1/server/form/getIflytekServer";
     ///  String url="http://localhost:8080/cloud-ai-robot-server/v1/word/form/getWordProcessing";
//	///	String url="http://localhost:8080/cloud-ai-robot-corpus/v1/dance/form/addDance_i_f_corpus";
//		
  //   while (true){
    	   
//    	
//   		MultiValueMap<String, Object> param = new LinkedMultiValueMap<String, Object>();
//   		param.add("robotId", String.valueOf(System.currentTimeMillis()));
//   		param.add("chatInfo", "我想听歌");
//   		
//   		String map=restTemplate.postForObject(url, param, String.class);
//   		System.out.println(map);
    	   
   ////   } 
        
//		
//		JSONObject jsonObject = JSONObject.parseObject(map);
//		long replyMsg = jsonObject.getLong("CreateTime");
//		System.out.println(System.currentTimeMillis() - replyMsg);
		

		
//		HttpHeaders headers = new HttpHeaders();
//
//		headers.setContentType(MediaType.APPLICATION_JSON);
//	
//		HttpEntity<JSONObject> entity = new HttpEntity<JSONObject>(json, headers);
//		// ResponseEntity<Student> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, Student.class, aa);
//		ResponseEntity<JSONObject> responseEntity = rest.postForEntity(url, entity, JSONObject.class, json);
//		System.out.println("测试Spring Rest的Post方法: " + responseEntity.getBody());
//		
//		///Student studentResult = responseEntity.getBody();
//		
//		
//		
		
		
		
//
//
//		JSONObject jsonObject = JSONObject.parseObject(json.toJSONString());
//		System.out.println("......"+jsonObject.getString("UserParams"));
//		jsonObject = JSONObject.parseObject(jsonObject.getString("Msg"));
//		
//		System.out.println("......"+jsonObject.getString("Content"));
//		
//		
//		
//		JSONObject  ret_Context=new JSONObject(true);
//		ret_Context.put("Type", "text");
//		ret_Context.put("ContentType", "Json");
//		ret_Context.put("Content", "eyJzbiI6MiwibHMiOnRydWUsImJnIjowLCJlZCI6MCwid3MiOlt7ImJnIj");
//		
//		JSONObject  ret_header=new JSONObject(true);
//		ret_header.put("MsgId", System.currentTimeMillis());
//		ret_header.put("CreateTime", System.currentTimeMillis());
//		ret_header.put("AppId", "508627e4");
//		ret_header.put("UserId", "d123455");	
//		ret_header.put("SessionParams", "Y21kPXNzYixzdWI9aWF0LHBsYXRmb3JtPWFuZG9yaWQ");
//		ret_header.put("UserParams", "PG5hbWU+eGlhb2JpYW5iaWFuPC9uYW1lPg==");		
//		ret_header.put("FromSub", "iat");
//		ret_header.put("Msg", ret_Context);	
//		ret_header.put("Res", "[]");
		
	
		
	}
	
	
}
