package com.efrobot.robotstore.awareness.business.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

public interface WeatherService {
	public JSONObject getcityInfo(String cityName);
	public String getCurrentCity();
	public Map<String, Object> getWeatherServer(String cityName);
}
