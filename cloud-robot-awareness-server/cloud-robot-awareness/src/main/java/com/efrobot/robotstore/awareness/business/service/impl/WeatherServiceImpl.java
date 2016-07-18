package com.efrobot.robotstore.awareness.business.service.impl;
import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.alibaba.fastjson.JSONObject;
import com.efrobot.robotstore.awareness.business.service.WeatherService;
import com.efrobot.robotstore.awareness.util.StringFilter;
import com.efrobot.toolkit.util.common.Util;
import com.efrobot.toolkit.util.xml.XMLParser;

@Service
public class WeatherServiceImpl implements WeatherService {
	
	
	public static final int getWeek() {
		Calendar now = Calendar.getInstance();
		// 一周第一天是否为星期天
		boolean isFirstSunday = (now.getFirstDayOfWeek() == Calendar.SUNDAY);
		// 获取周几
		int weekDay = now.get(Calendar.DAY_OF_WEEK);
		// 若一周第一天为星期天，则-1
		if (isFirstSunday) {
			weekDay = weekDay - 1;
			if (weekDay == 0) {
				weekDay = 7;
			}
		}
	 return weekDay;
	}
	

	public JSONObject getcityInfo(String cityName)  {
		
		JSONObject result = new JSONObject();
		URL url1 = null;
		URLConnection connection = null;
		
		try {
			url1 = new URL(
					"http://php.weather.sina.com.cn/xml.php?city=" + cityName + "&password=DJOYnieT8234jlsK&day=0");
		    connection = url1.openConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		StringBuilder response = new StringBuilder();
		
		if (null!=connection) {
			Scanner in = null;
			try {
					
					in = new Scanner(connection.getInputStream(),"utf-8");					
					while (in.hasNextLine()) {
						response.append(in.nextLine());
						response.append("\n");
					}
					
				} catch (IOException e) {
					if (connection instanceof HttpURLConnection) {
						InputStream err = ((HttpURLConnection) connection).getErrorStream();
						if (null!=err) {
							in = new Scanner(err,"utf-8");
							response.append(in.nextLine());
							response.append("\n");
						}				
					}	
				} finally {
					if (null!=in) {
						in.close();
					}
				}
			
		}

		String result1 = response.toString();
		
		
		System.out.println("..........."+result1);

		if (null!=result1 && !"".equals(result1)) {
			
			InputStream is = null;
		
			try {

				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				is = Util.getStringStream(result1);
				Document document = builder.parse(is);

				NodeList allNodes = document.getElementsByTagName("status1");

				Node node;
				Map<String, String> map = new HashMap<String, String>();
				int i = 0;
				
				while (i < allNodes.getLength()) {
					node = allNodes.item(i);
					if (node instanceof Element) {
						map.put(node.getNodeName(), node.getTextContent());
					}
					i++;
				}
				
				NodeList allNodes_ = document.getElementsByTagName("status2");

				Node node_;
				Map<String, String> map_ = new HashMap<String, String>();
				int i_ = 0;
				
				while (i_ < allNodes_.getLength()) {
					node_ = allNodes_.item(i_);
					if (node_ instanceof Element) {
						map_.put(node_.getNodeName(), node_.getTextContent());
					}
					i_++;
				}
				
				String status=null;

				String status1 = map.get("status1")+"转"+map_.get("status2");
				System.out.println(status1);
				
				int indexof = status1.lastIndexOf("雨");
				int indexof_q = status1.lastIndexOf("晴");
				int indexof_y = status1.lastIndexOf("云");
				
				int indexof_y_ = status1.indexOf("晴");
				int indexof_q_ = status1.lastIndexOf("霾");
				
				if (indexof > 0) {
					status="1";
				} else if (indexof_q > 0) {
					status="10";
				} else if (indexof_y > 0) {
					status="11";
				} else if (indexof_y_ >= 0 && indexof_q_ > 0) {
					status="12";
				}
				
				result.put("weatherStatus", status);
				result.put("weatherMsg", status1);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (null!=is) {
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		
		return result;
	}

	public String getCurrentCity() {
	
		String webapiUrl = "http://webapi.amap.com/maps/ipLocation?key=608d75903d29ad471362f8c58c550daf";

		StringBuffer strBuf = new StringBuffer();
		BufferedReader reader = null;
		URLConnection conn = null;
		try {
			
			URL url = new URL(webapiUrl);
		    conn = url.openConnection();
		    reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			
		    String line = null;
			while ((line = reader.readLine()) != null) {
				
				strBuf.append(line + " ");
				
			}			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null!=reader) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return strBuf.toString();
	}
	
	 public static void main(String[] args) throws IOException {
//		String result= WeatherImpl.getCurrentCity();
//		result=result.substring(1, result.lastIndexOf(")"));
//		JSONObject jsonObject = JSONObject.parseObject(result);
//		String replyMsg = jsonObject.getString("city");
//		System.out.println(replyMsg);
//	
//		JSONObject result_=WeatherImpl.getcityInfo(java.net.URLEncoder.encode(StringFilter.StringFilter("北京市"),"GBK"));
//        System.out.println(result_);	
		 
//		int startTime=1;
//		int endTime=7;
//		
//		int week = WeatherImpl.getWeek();
//		
//		if ((week >=startTime) && (week <=endTime)) {
//			System.out.println(week);
//		}

		
	 }


	@Override
	public JSONObject getWeatherServer(String cityName) {
		JSONObject result_ = null;
		
		try {
			
			if (null == cityName || "".equals(cityName)) {

				String result = this.getCurrentCity();
				result = result.substring(1, result.lastIndexOf(")"));
				JSONObject jsonObject = JSONObject.parseObject(result);
				String replyMsg = jsonObject.getString("city");

				result_ = this.getcityInfo(java.net.URLEncoder.encode(StringFilter.StringFilter(replyMsg), "GBK"));

			} else {

				result_ = this.getcityInfo(java.net.URLEncoder.encode(StringFilter.StringFilter(cityName), "GBK"));

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	  return result_;
	}
	
}
