package com.efrobot.robotstore.awareness.base.dao;

import com.efrobot.robotstore.awareness.base.pojo.AwarenessParamVO;
import com.efrobot.robotstore.awareness.base.pojo.AwarenessVO;

public interface Awareness_service_tbMapper {
	
	public java.util.List<AwarenessVO> selectByAwareness(AwarenessParamVO awarenessParamVO);
	
}
