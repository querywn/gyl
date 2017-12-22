package com.neo.gyl.privilege.action;

import java.util.Collection;
import java.util.HashSet;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neo.gyl.base.BaseAction;
import com.neo.gyl.domain.privilege.Privilege;
import com.neo.gyl.domain.privilege.Role;
import com.neo.gyl.privilege.service.PrivilegeService;
import com.neo.gyl.privilege.service.RoleService;
import com.opensymphony.xwork2.ActionContext;

@Controller("privilegeAction")
@Scope("prototype")
public class PrivilegeAction extends BaseAction<Privilege> {

	@Resource(name = "privilegeService")
	private PrivilegeService privilegeService;

	@Resource(name = "roleService")
	private RoleService roleService;

	public String showPrivilegeTree() throws Exception {
		//Collection<Privilege> privileges = this.privilegeService.getAllEntries();
		Collection<Privilege> privileges = this.privilegeService.getPrivilegesWithChecked(rid);
		ActionContext.getContext().getValueStack().push(privileges);
		return SUCCESS;
	}

	private Integer rid;
	private String checkedStr;

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getCheckedStr() {
		return checkedStr;
	}

	public void setCheckedStr(String checkedStr) {
		this.checkedStr = checkedStr;
	}

	public String updateRolePrivileges() throws Exception {
		Role role = this.roleService.getEntryById(this.rid);
		if(StringUtils.isBlank(checkedStr)){
			role.setPrivileges(null);
		} else {
			Collection<Privilege> privileges = this.privilegeService.getEntriesByIds(this.checkedStr.split("\\,"));
			role.setPrivileges(new HashSet<Privilege>(privileges));
		}
		this.roleService.updateEntry(role);
		return SUCCESS;
	}
}
