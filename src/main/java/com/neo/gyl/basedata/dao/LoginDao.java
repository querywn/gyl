package com.neo.gyl.basedata.dao;

import com.neo.gyl.domain.basedata.User;

public interface LoginDao {
	public User authentication(String username,String password);
}
