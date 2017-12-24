package com.neo.gyl.privilege.dao;

import java.util.Collection;

import com.neo.gyl.base.BaseDao;
import com.neo.gyl.domain.privilege.Privilege;

public interface PrivilegeDao extends BaseDao<Privilege>{
	public Collection<Privilege> getPrivilegesByRid(Integer rid);
	public Collection<Privilege> getMenuitemsByUid(Integer uid);
}
