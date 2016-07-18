package com.efrobot.robotstore.awareness.job;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class QuartzJob   {
	
	private final java.text.SimpleDateFormat dateFormat=new java.text.SimpleDateFormat("yyyy-MM-dd");
	private static RestTemplate restTemplate = com.efrobot.toolkit.util.http.RestClient.getInstance();

	public void execute() {
		
		  MultiValueMap<String, Object> param = new LinkedMultiValueMap<String, Object>();
		  param.add("cityName","");
 		  String map=restTemplate.postForObject("", param, String.class);
 		  System.out.println(map);
 		  
 		  
 		  
		System.out.println("jkjkfddddddddddddddddddddddddd-------");
//		List<AwarenessVO> awarenessList=awarenessService.selectByAwareness(new AwarenessVO());
//
//		for (AwarenessVO awarenessVO : awarenessList) {
//			
//			System.out.println(awarenessVO.getAwareness_url());
//			
//		}
//		
		
//		java.util.Date startDate=null;
//		java.util.Date endDate=null;
//		try {
//			startDate = dateFormat.parse("2016-07-09");
//			endDate=dateFormat.parse("2016-07-11");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		java.util.Date currentDate=new java.util.Date();
//		
//		if (currentDate.before(endDate) && currentDate.after(startDate)) {
//			
//			String currentTime=new SimpleDateFormat("HH:mm").format(new Date());
//
//			if (null!=currentTime && "14:51".equals(currentTime)) {
//				System.out.println("jkjkfddddddddddddddddddddddddd");
//				
//			}
//			
//		}
		
	
		
	}  
}
