package com.efrobot.robotstore.awareness.business.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

import com.efrobot.toolkit.util.http.RestClient;
import com.efrobot.toolkit.util.web.controller.BaseController;
import com.mysql.jdbc.util.Base64Decoder;
import com.efrobot.robotstore.awareness.business.service.impl.WeatherServiceImpl;
import com.efrobot.robotstore.awareness.util.IOUtil;
import com.efrobot.robotstore.awareness.util.ResourceUtil;
import com.efrobot.robotstore.awareness.util.StringFilter;
import com.efrobot.robotstore.awareness.util.StringParserUtil;

@RequestMapping("/v1/server")
@RestController
public class ServerController extends BaseController {

	private static final Logger log = LoggerFactory.getLogger(ServerController.class);
	private final ResourceUtil resourceUtil=ResourceUtil.getInstance();

	private final java.text.SimpleDateFormat dateFormat=new java.text.SimpleDateFormat("yyyy-MM-dd");

	
//
//	@RequestMapping(value = "/form/getWeatherServer", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
//	@ResponseBody
//	public Map<String, Object> getWeatherServer(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		try {
//			request.setCharacterEncoding("utf-8");
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}
//		response.setCharacterEncoding("utf-8");
//		
//		String cityName=request.getParameter("cityName");
//		JSONObject result_= null;
//		
//		if (null==cityName || "".equals(cityName)) {
//			
//			String result= WeatherServiceImpl.getCurrentCity();
//			result=result.substring(1, result.lastIndexOf(")"));
//			JSONObject jsonObject = JSONObject.parseObject(result);
//			String replyMsg = jsonObject.getString("city");
//			result_=WeatherServiceImpl.getcityInfo(java.net.URLEncoder.encode(StringFilter.StringFilter(replyMsg),"GBK"));
//			
//		} else {
//			
//			result_=WeatherServiceImpl.getcityInfo(java.net.URLEncoder.encode(StringFilter.StringFilter(cityName),"GBK"));
//	       
//		}
//		 System.out.println(result_);	
//		return result_;
//	}
//	


}
