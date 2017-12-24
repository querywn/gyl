package com.neo.gyl.privilege.service;

import java.util.Collection;

import com.neo.gyl.base.BaseService;
import com.neo.gyl.domain.privilege.Privilege;

public interface PrivilegeService extends BaseService<Privilege>{
	public Collection<Privilege> getPrivilegesWithChecked(Integer rid);
	public Collection<Privilege> getMenuitemsByUid(Integer uid);
}
