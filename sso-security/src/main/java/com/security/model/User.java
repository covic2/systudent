package com.security.model;

public class User {
	private String user;
	private String password;
	private String rol;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	@Override
	public String toString() {
		return "User [user=" + user + ", password=" + password + ", rol=" + rol + "]";
	}
	
}
