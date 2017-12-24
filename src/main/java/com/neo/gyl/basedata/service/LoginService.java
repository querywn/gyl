package com.neo.gyl.basedata.service;

import com.neo.gyl.domain.basedata.User;

public interface LoginService {
	public User authentication(String username,String password);
}
