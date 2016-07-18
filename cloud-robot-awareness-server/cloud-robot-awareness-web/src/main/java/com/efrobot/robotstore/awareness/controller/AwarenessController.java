package com.efrobot.robotstore.awareness.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.efrobot.toolkit.util.security.MD5;
import com.efrobot.toolkit.util.web.controller.BaseController;
import com.efrobot.toolkit.util.web.servlet.Keys;

import net.sf.json.JsonConfig;


@RequestMapping("/v1/awareness")
@RestController
public class AwarenessController extends BaseController {

	private static final Logger log = LoggerFactory.getLogger(AwarenessController.class);
	private final java.text.SimpleDateFormat dateFormat=new java.text.SimpleDateFormat("yyyy-MM-dd");
	private final java.text.SimpleDateFormat dateFormat_hh=new java.text.SimpleDateFormat("HH:mm");
	private static RestTemplate restTemplate = com.efrobot.toolkit.util.http.RestClient.getInstance();
	
	
	
//	@Autowired
//	@Qualifier("awarenessServiceImpl")
//	private AwarenessService awarenessServiceImpl;

	@RequestMapping(value = "/form/getWeatherServer_business", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@ResponseBody
	public Map<String, Object> getWeatherServer_business(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		response.setCharacterEncoding("utf-8");

		return null;
	}
	
	
	
	
	

}
