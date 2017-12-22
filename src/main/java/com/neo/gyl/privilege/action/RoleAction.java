package com.neo.gyl.privilege.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neo.gyl.base.BaseAction;
import com.neo.gyl.domain.privilege.Role;
import com.neo.gyl.privilege.service.RoleService;
import com.opensymphony.xwork2.ActionContext;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	
	@Resource(name="roleService")
	private RoleService roleService;
	
	public String showRoleTree() throws Exception {
		Collection<Role> roles = this.roleService.getAllEntries();
		ActionContext.getContext().getValueStack().push(roles);
		return SUCCESS;
	}
	
	public String add() throws Exception {
		Role role = new Role();
		BeanUtils.copyProperties(role, this.getModel());
		this.roleService.saveEntry(role);
		
		ActionContext.getContext().getValueStack().push(role);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		this.roleService.deleteEntryById(this.getModel().getRid());
		return SUCCESS;
	}
	
	public String update() throws Exception {
		Role role = this.roleService.getEntryById(this.getModel().getRid());
		role.setName(this.getModel().getName());
		this.roleService.updateEntry(role);
		return SUCCESS;
	}
	
	public String showRoles() throws Exception {
		Collection<Role> roles = this.roleService.getAllEntries();
		ActionContext.getContext().put("roles", roles);
		return LISTACTION;
	}
}
