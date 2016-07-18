package com.efrobot.robotstore.awareness.base.pojo;

import com.efrobot.robotstore.awareness.util.Base;

public class Robot_awareness_service_tb extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	// 机器人ID
	private String robot_id;
	// 设备ID
	private String device_id;
	// 意识ID
	private String awareness_id;
	// 服务开始时间
	private java.util.Date service_start_time;
	// 服务结束时间
	private java.util.Date service_end_time;
	// 服务状态 1 正常使用
	private String service_status;
	// 创建时间
	private java.util.Date create_date;
	// 区域编码  如 110000  　北京市
	private String area_code;

	public String getArea_code() {
		return area_code;
	}

	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getAwareness_id() {
		return awareness_id;
	}

	public void setAwareness_id(String awareness_id) {
		this.awareness_id = awareness_id;
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

	public java.util.Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(java.util.Date create_date) {
		this.create_date = create_date;
	}

}
