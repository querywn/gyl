package com.neo.gyl.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.neo.gyl.basedata.dao.LoginDao;
import com.neo.gyl.basedata.service.LoginService;
import com.neo.gyl.domain.basedata.User;

@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Resource(name="loginDao")
	private LoginDao loginDao;
	
	public User authentication(String username, String password) {
		return this.loginDao.authentication(username, password);
	}
	
}
