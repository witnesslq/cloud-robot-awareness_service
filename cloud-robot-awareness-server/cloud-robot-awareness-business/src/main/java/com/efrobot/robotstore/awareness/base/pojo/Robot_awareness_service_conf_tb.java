package com.efrobot.robotstore.awareness.base.pojo;

import com.efrobot.robotstore.awareness.util.Base;

public class Robot_awareness_service_conf_tb extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	// 机器人ID
    private String robot_id;
    // 设备ID
    private String device_id;
    // 意识ID
    private String awareness_id;
    // 意识服务参数
    private String awareness_param;
    // 意识服务回复
    private String awareness_feedback;
    // 创建时间
    private String create_date;

	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
}	
