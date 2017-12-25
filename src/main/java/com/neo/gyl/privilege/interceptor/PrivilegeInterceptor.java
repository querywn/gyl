package com.neo.gyl.privilege.interceptor;

import java.util.Collection;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.neo.gyl.domain.privilege.Privilege;
import com.neo.gyl.privilege.annotation.AnnoactionParser;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Class targetClass = invocation.getAction().getClass();
		String methodName = invocation.getProxy().getMethod();
		String accessMethodName = AnnoactionParser.parse(targetClass, methodName);
		//如果权限的要求是""  直接放行
		if(StringUtils.isBlank(accessMethodName)){
			return invocation.invoke();
		}
		//如果当前用户拥有的权限包含当前方法需要的权限，放行
		Collection<Privilege> functions = (Collection<Privilege>) ServletActionContext.getRequest().getSession().getAttribute("functions");
		for (Privilege privilege : functions) {
			if(accessMethodName.equals(privilege.getName())){
				return invocation.invoke();
			}
		}
		
		//如果当前用户拥有的权限不包含当前方法需要的权限，跳转到消息提示页面
		ServletActionContext.getContext().getValueStack().push("你没有访问权限，请联系管理员");
		return "message";
	}

}
