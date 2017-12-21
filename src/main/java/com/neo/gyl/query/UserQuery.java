package com.neo.gyl.query;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class UserQuery extends BaseQuery {

	private String username;
	private String email;
	@Override
	public Map<String, Object> buildConditionMap() {
		if(StringUtils.isNotBlank(username)){
			this.getConditionMap().put("username",username);
		}
		if(StringUtils.isNotBlank(email)){
			this.getConditionMap().put("email",email);
		}
		return this.getConditionMap();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
