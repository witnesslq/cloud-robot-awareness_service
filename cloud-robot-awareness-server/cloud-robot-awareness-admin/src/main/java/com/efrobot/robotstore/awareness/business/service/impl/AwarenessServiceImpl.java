package com.efrobot.robotstore.awareness.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efrobot.robotstore.awareness.base.dao.Awareness_service_tbMapper;
import com.efrobot.robotstore.awareness.base.pojo.AwarenessVO;
import com.efrobot.robotstore.awareness.business.service.AwarenessService;

@Service("awarenessServiceImpl")
public class AwarenessServiceImpl implements AwarenessService {

	@Autowired
	private Awareness_service_tbMapper awareness_service_tbMapper;

	@Override
	public java.util.List<AwarenessVO> selectByAwareness() {
		// TODO Auto-generated method stub
		return awareness_service_tbMapper.selectByAwareness();
	}

}
