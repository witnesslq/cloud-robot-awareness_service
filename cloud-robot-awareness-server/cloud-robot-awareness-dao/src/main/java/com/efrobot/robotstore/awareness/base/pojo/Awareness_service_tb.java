package com.efrobot.robotstore.awareness.base.pojo;

public class Awareness_service_tb implements java.io.Serializable {

	private static final long serialVersionUID = -8773482608508252706L;
	
	private Integer id;
	// 意识名称
	private String awareness_name;
	// 意识URL
	private String awareness_url;
	// 意识 状态 1 启动;0 禁用
	private String awareness_status;
	// 意识类型 1 实现微服务
	private String awareness_type;
	// 创建时间
	private java.util.Date create_date;
	//意识参数解析URL
	private String awareness_b_url;

	public String getAwareness_b_url() {
		return awareness_b_url;
	}

	public void setAwareness_b_url(String awareness_b_url) {
		this.awareness_b_url = awareness_b_url;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getAwareness_status() {
		return awareness_status;
	}

	public void setAwareness_status(String awareness_status) {
		this.awareness_status = awareness_status;
	}

	public String getAwareness_type() {
		return awareness_type;
	}

	public void setAwareness_type(String awareness_type) {
		this.awareness_type = awareness_type;
	}

	public java.util.Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(java.util.Date create_date) {
		this.create_date = create_date;
	}

}
