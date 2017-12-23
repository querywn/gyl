package com.neo.gyl.privilege.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.neo.gyl.base.BaseDao;
import com.neo.gyl.base.BaseServiceImpl;
import com.neo.gyl.domain.privilege.Role;
import com.neo.gyl.privilege.dao.RoleDao;
import com.neo.gyl.privilege.service.RoleService;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{
	
	@Resource(name="roleDao")
	private RoleDao roleDao;
	
	@Override
	public BaseDao<Role> getBaseDao() {
		return this.roleDao;
	}
	
	public Role getByName(String name) {
		return this.roleDao.getByName(name);
	}

	public Collection<Role> getRolesWithChecked(Integer uid) {
		Collection<Role> roles = this.roleDao.getAllEntries();
		Collection<Role> checkedRoles = this.roleDao.getRolesByUid(uid);
		for (Role role : roles) {
			if(checkedRoles.contains(role)){
				role.setChecked(true);
			}
		}
		return roles;
	}

}
