package com.neo.gyl.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.neo.gyl.base.BaseDao;
import com.neo.gyl.base.BaseServiceImpl;
import com.neo.gyl.basedata.dao.UserDao;
import com.neo.gyl.basedata.service.UserService;
import com.neo.gyl.domain.basedata.User;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	@Resource(name="userDao")
	private UserDao userDao;
	
	@Override
	public BaseDao<User> getBaseDao() {
		return this.userDao;
	}

}
