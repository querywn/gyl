package com.neo.gyl.privilege.dao;

import com.neo.gyl.base.BaseDao;
import com.neo.gyl.domain.privilege.Role;

public interface RoleDao extends BaseDao<Role>{
	public Role getByName(final String name);
}
