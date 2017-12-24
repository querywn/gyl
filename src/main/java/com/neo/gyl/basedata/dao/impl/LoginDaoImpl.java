package com.neo.gyl.basedata.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.neo.gyl.basedata.dao.LoginDao;
import com.neo.gyl.domain.basedata.User;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	public User authentication(String username, String password) {
		List<User> users =  this.hibernateTemplate.find("from User where username=? and password=?", username, password);
		return users.size()==0?null:users.get(0);
	}

}
