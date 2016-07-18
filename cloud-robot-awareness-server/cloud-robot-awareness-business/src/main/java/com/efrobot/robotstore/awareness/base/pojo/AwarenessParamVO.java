package com.efrobot.robotstore.awareness.base.pojo;

public class AwarenessParamVO implements java.io.Serializable {

	private static final long serialVersionUID = -8773482608508252706L;

	// 意识类型 1 MQTT 类型 2 HTTP 类型
	private String awareness_type;
	// 区域编码
	private String area_code;

	public String getAwareness_type() {
		return awareness_type;
	}

	public void setAwareness_type(String awareness_type) {
		this.awareness_type = awareness_type;
	}

	public String getArea_code() {
		return area_code;
	}

	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}

}
