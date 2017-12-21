package com.neo.gyl.privilege.service;

import com.neo.gyl.base.BaseService;
import com.neo.gyl.domain.privilege.Role;

public interface RoleService extends BaseService<Role>{
	public Role getByName(final String name);
}
