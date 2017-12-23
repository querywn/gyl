package com.neo.gyl.privilege.dao;

import java.util.Collection;

import com.neo.gyl.base.BaseDao;
import com.neo.gyl.domain.privilege.Role;

public interface RoleDao extends BaseDao<Role>{
	public Role getByName(final String name);
	public Collection<Role> getRolesByUid(Integer uid); 
}
