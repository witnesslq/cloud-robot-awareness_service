package com.efrobot.robotstore.awareness.util;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class UserBean implements Serializable {
	private Integer orderUserId;

	public Integer getOrderUserId() {
		return orderUserId;
	}

	public void setOrderUserId(Integer orderUserId) {
		this.orderUserId = orderUserId;
	}

	private Integer userId;

	private String userName;

	private String nickName;

	private Short sex;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	private String phoneNum;

	private String email;

	private String qq;

	private String weixin;

	private String province;

	private String city;

	private String area;

	private String street;

	private Date createDate;

	private Date modifyDate;

	private Short dataState;

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Short getSex() {
		return sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Short getDataState() {
		return dataState;
	}

	public void setDataState(Short dataState) {
		this.dataState = dataState;
	}

	@Override
	public String toString() {
		return "UserBean [orderUserId=" + orderUserId + ", userId=" + userId + ", userName=" + userName + ", nickName=" + nickName + ", sex=" + sex + ", birthday=" + birthday + ", phoneNum="
				+ phoneNum + ", email=" + email + ", qq=" + qq + ", weixin=" + weixin + ", province=" + province + ", city=" + city + ", area=" + area + ", street=" + street + ", createDate="
				+ createDate + ", modifyDate=" + modifyDate + ", dataState=" + dataState + "]";
	}

}
