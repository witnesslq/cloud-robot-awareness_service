package com.efrobot.robotstore.awareness.base.dao;

import java.util.List;

import com.efrobot.robotstore.awareness.base.pojo.AwarenessVO;
import com.efrobot.robotstore.awareness.base.pojo.Robot_awareness_service_tb;

public interface Awareness_service_tbMapper {
	
	
	java.util.List<AwarenessVO> selectByAwareness();
	
}
