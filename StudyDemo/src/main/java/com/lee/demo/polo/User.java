package com.lee.demo.polo;

public class User {
	
	public User(String userName, String password, String sex, int age) {
		this.userNmae = userName;
		this.password = password;
		this.sex = sex;
		this.age = age;
	}
	private String userNmae;

	public String getUserNmae() {
		return userNmae;
	}

	public void setUserNmae(String userNmae) {
		this.userNmae = userNmae;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private String password;
	private String sex;
	private int age;
}
