package com.api.pojo_day1;

public class LoginPOJO {
	protected String username;
	protected String password;
	public LoginPOJO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginPOJO [username=" + username + ", password=" + password + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
