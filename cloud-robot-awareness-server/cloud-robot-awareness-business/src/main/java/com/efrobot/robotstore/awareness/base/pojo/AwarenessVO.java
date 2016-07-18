package com.efrobot.robotstore.awareness.base.pojo;

public class AwarenessVO implements java.io.Serializable {

	private static final long serialVersionUID = -8773482608508252706L;

	private String robot_id;
	private String device_id;
	private String awareness_name;
	private String awareness_url;
	private String awareness_param;
	private String awareness_feedback;
	private java.util.Date service_start_time;
	private java.util.Date service_end_time;
	private String service_status;
	// 意识参数解析URL
	private String awareness_b_url;

	public String getAwareness_b_url() {
		return awareness_b_url;
	}

	public void setAwareness_b_url(String awareness_b_url) {
		this.awareness_b_url = awareness_b_url;
	}

	public String getRobot_id() {
		return robot_id;
	}

	public void setRobot_id(String robot_id) {
		this.robot_id = robot_id;
	}

	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	public String getAwareness_name() {
		return awareness_name;
	}

	public void setAwareness_name(String awareness_name) {
		this.awareness_name = awareness_name;
	}

	public String getAwareness_url() {
		return awareness_url;
	}

	public void setAwareness_url(String awareness_url) {
		this.awareness_url = awareness_url;
	}

	public String getAwareness_param() {
		return awareness_param;
	}

	public void setAwareness_param(String awareness_param) {
		this.awareness_param = awareness_param;
	}

	public String getAwareness_feedback() {
		return awareness_feedback;
	}

	public void setAwareness_feedback(String awareness_feedback) {
		this.awareness_feedback = awareness_feedback;
	}

	public java.util.Date getService_start_time() {
		return service_start_time;
	}

	public void setService_start_time(java.util.Date service_start_time) {
		this.service_start_time = service_start_time;
	}

	public java.util.Date getService_end_time() {
		return service_end_time;
	}

	public void setService_end_time(java.util.Date service_end_time) {
		this.service_end_time = service_end_time;
	}

	public String getService_status() {
		return service_status;
	}

	public void setService_status(String service_status) {
		this.service_status = service_status;
	}

}
