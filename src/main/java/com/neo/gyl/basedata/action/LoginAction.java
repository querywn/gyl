package com.neo.gyl.basedata.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neo.gyl.base.BaseAction;
import com.neo.gyl.basedata.service.LoginService;
import com.neo.gyl.domain.basedata.User;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<User> {
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	public String authentication() throws Exception {
		User user = this.loginService.authentication(this.getModel().getUsername(), this.getModel().getPassword());
		if(user == null){
			this.addActionError("用户名或密码错误");
			return "login";
		} else {
			this.getSession().setAttribute("user", user);
			return "index";
		}
	}
	
}
