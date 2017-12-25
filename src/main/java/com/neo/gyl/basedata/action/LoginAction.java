package com.neo.gyl.basedata.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neo.gyl.base.BaseAction;
import com.neo.gyl.basedata.service.LoginService;
import com.neo.gyl.domain.basedata.User;
import com.neo.gyl.domain.privilege.Privilege;
import com.neo.gyl.privilege.service.PrivilegeService;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<User> {
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	@Resource(name="privilegeService")
	private PrivilegeService privilegeService;
	
	public String authentication() throws Exception {
		User user = this.loginService.authentication(this.getModel().getUsername(), this.getModel().getPassword());
		if(user == null){
			this.addActionError("用户名或密码错误");
			return "login";
		} else {
			this.getSession().setAttribute("user", user);
			//获取当前用户的功能列表
			Collection<Privilege> functions = this.privilegeService.getFunctionsByUid(user.getUid());
			this.getSession().setAttribute("functions",functions);
			return "index";
		}
	}
	
}
