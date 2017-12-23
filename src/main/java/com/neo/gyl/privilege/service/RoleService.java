package com.neo.gyl.privilege.service;

import java.util.Collection;

import com.neo.gyl.base.BaseService;
import com.neo.gyl.domain.privilege.Role;

public interface RoleService extends BaseService<Role>{
	public Role getByName(final String name);
	public Collection<Role> getRolesWithChecked(Integer uid);
}
