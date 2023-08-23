package com.mycompany.exam.domain;

public class User {


	private Integer userId;
	private String name;
	private String phone;
	private String email;
	private String userName;
	private String password;
	private Integer role;
	private Integer loginStatus;
	private String profile;

	public User() {
	}

	public User(Integer userId, String name, String phone, String email, String userName, String password, Integer role,
			Integer loginStatus, String profile) {

		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.loginStatus = loginStatus;
		this.profile = profile;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(Integer loginStatus) {
		this.loginStatus = loginStatus;
	}

}
