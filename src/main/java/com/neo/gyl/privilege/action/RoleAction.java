package com.neo.gyl.privilege.action;

import java.util.Collection;
import java.util.HashSet;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neo.gyl.base.BaseAction;
import com.neo.gyl.basedata.service.UserService;
import com.neo.gyl.domain.basedata.User;
import com.neo.gyl.domain.privilege.Role;
import com.neo.gyl.privilege.service.RoleService;
import com.opensymphony.xwork2.ActionContext;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	
	@Resource(name="roleService")
	private RoleService roleService;
	
	@Resource(name="userService")
	private UserService userService;
	
	public String showRoleTree() throws Exception {
		//Collection<Role> roles = this.roleService.getAllEntries();
		Collection<Role> roles = this.roleService.getRolesWithChecked(uid);
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
	
	public String showUsers() throws Exception {
		Collection<User> users = this.userService.getAllEntries();
		ActionContext.getContext().put("users", users);
		return LISTACTION;
	}
	
	private Integer uid;
	
	

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String updateUserRoles() throws Exception {
		User user = this.userService.getEntryById(this.uid);
		if(StringUtils.isBlank(this.getCheckedStr())){
			user.setRoles(null);
		} else {
			Collection<Role> roles = this.roleService.getEntriesByIds(this.getCheckedStr().split("\\,"));
			user.setRoles(new HashSet<Role>(roles));
		}
		this.userService.updateEntry(user);
		return SUCCESS;
	}
	
}
