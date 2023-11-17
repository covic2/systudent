package com.security.model;

import java.util.List;

public class Client {
	private String client;
	private String secret;
	private List<String> grantTypes;
	private List<String> authorities;
	private List<String> scope;
	private Integer accessSecond;
	private Integer refreshSecond;
	
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public List<String> getGrantTypes() {
		return grantTypes;
	}
	public void setGrantTypes(List<String> grantTypes) {
		this.grantTypes = grantTypes;
	}
	
	
	public List<String> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}
	public List<String> getScope() {
		return scope;
	}
	public void setScope(List<String> scope) {
		this.scope = scope;
	}
	public Integer getAccessSecond() {
		return accessSecond;
	}
	public void setAccessSecond(Integer accessSecond) {
		this.accessSecond = accessSecond;
	}
	public Integer getRefreshSecond() {
		return refreshSecond;
	}
	public void setRefreshSecond(Integer refreshSecond) {
		this.refreshSecond = refreshSecond;
	}
	
	
	
}
