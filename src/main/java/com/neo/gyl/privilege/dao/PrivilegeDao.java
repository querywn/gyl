package com.neo.gyl.privilege.dao;

import java.util.Collection;

import com.neo.gyl.base.BaseDao;
import com.neo.gyl.domain.privilege.Privilege;

public interface PrivilegeDao extends BaseDao<Privilege>{
	public Collection<Privilege> getPrivilegesByRid(Integer rid);
	//获取当前用户的菜单权限
	public Collection<Privilege> getMenuitemsByUid(Integer uid);
	//获取当前用户的功能权限
	public Collection<Privilege> getFunctionsByUid(Integer uid);
}
