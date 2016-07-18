package com.efrobot.robotstore.awareness.business.controller;

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
import com.efrobot.robotstore.awareness.base.pojo.AwarenessParamVO;
import com.efrobot.robotstore.awareness.base.pojo.AwarenessVO;
import com.efrobot.robotstore.awareness.base.pojo.Robot_awareness_service_tb;
import com.efrobot.robotstore.awareness.business.service.AwarenessService;
import com.efrobot.robotstore.awareness.business.service.WeatherService;
import com.efrobot.robotstore.awareness.util.StringFilter;
import com.efrobot.robotstore.awareness.util.UserBean;
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

	@Autowired
	private AwarenessService awarenessServiceImpl;
	
	@Autowired
	private WeatherService weatherServiceImpl;

	/**
	 * 天气服务参数解析程序
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/form/getWeatherServer_Parser", method = RequestMethod.POST, produces = {
			"application/text;charset=UTF-8" })
	@ResponseBody
	public String getWeatherServer_Parser(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		response.setCharacterEncoding("utf-8");

		String awareness_param=request.getParameter("awareness_param");
		
		if (null!=awareness_param && !"".equals(awareness_param)) {
			
			JSONObject obj = JSONObject.parseObject(awareness_param);

			System.out.println(obj.getString("beginTime"));
			System.out.println(obj.getString("endTime"));
			System.out.println(obj.getString("actionTime"));

			java.util.Date startDate = null;
			java.util.Date endDate = null;
			try {
				startDate = dateFormat.parse(obj.getString("beginTime"));
				endDate = dateFormat.parse(obj.getString("endTime"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			java.util.Date currentDate = new java.util.Date();
			
			// 在时间区间内
			if (currentDate.before(endDate) && currentDate.after(startDate)) {

				String currentTime = dateFormat_hh.format(new Date());

				if (null != currentTime && !"".equals(currentTime)) {

					String actionTime = obj.getString("actionTime");

					/// if (null!=actionTime && actionTime.equals(currentTime))
					/// {
					JSONObject weatherContext = weatherServiceImpl.getWeatherServer("");
					
					if (null!=weatherContext) {
						System.out.println("ppppppppppppppppppppppppp"+weatherContext.getString("weatherMsg"));
						return weatherContext.getString("weatherMsg");
					}
					/// }

				}

			}
			
		}

		return null;
	}
	
	@RequestMapping(value = "/form/getTest", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@ResponseBody
	public Map<String, Object> getTest(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		Map<String, Object> weatherContext=weatherServiceImpl.getWeatherServer("");
		System.out.println("weatherServiceImpl......."+weatherContext);
		
		
		response.setCharacterEncoding("utf-8");

		return null;
	}
	
	
	
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
		
		// 区域编码
		String area_code=request.getParameter("area_code");
		
		if (null!=area_code && !"".equals(area_code)) {
			
			AwarenessParamVO awarenessParamVO = new AwarenessParamVO();
			awarenessParamVO.setArea_code(area_code);
			awarenessParamVO.setAwareness_type("1");
			List<AwarenessVO> awarenessList=awarenessServiceImpl.selectByAwareness(awarenessParamVO);

			for (AwarenessVO awarenessVO : awarenessList) {
		
				
				  System.out.println("url--------------------------"+awarenessVO.getAwareness_b_url());
				  MultiValueMap<String, Object> param = new LinkedMultiValueMap<String, Object>();
				  param.add("awareness_param",awarenessVO.getAwareness_param());
		 		  String map=restTemplate.postForObject(awarenessVO.getAwareness_b_url(), param, String.class);
		 		 
		 		  if (null!=map && !"".equals(map)) {
		 			  
		 			 String feedback=awarenessVO.getAwareness_feedback().replaceAll("#A", map);
		 			 System.out.println("00000000000000000000----"+feedback);
		 		  }
		 		 
		 		  
			}
		}

		return null;
	}
	
	
	
	
	

}
