package com.neo.gyl.privilege.service.impl;

import java.util.Collection;
import java.util.Iterator;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.neo.gyl.base.BaseDao;
import com.neo.gyl.base.BaseServiceImpl;
import com.neo.gyl.domain.privilege.Privilege;
import com.neo.gyl.privilege.dao.PrivilegeDao;
import com.neo.gyl.privilege.service.PrivilegeService;

@Service("privilegeService")
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege> implements PrivilegeService{

	@Resource(name="privilegeDao")
	private PrivilegeDao privilegeDao;
	
	@Override
	public BaseDao<Privilege> getBaseDao() {
		return this.privilegeDao;
	}

	public Collection<Privilege> getPrivilegesWithChecked(Integer rid) {
		Collection<Privilege> privileges = this.privilegeDao.getAllEntries();
		Collection<Privilege> checkedPrivileges = this.privilegeDao.getPrivilegesByRid(rid);
		for (Privilege privilege : privileges) {
			if(checkedPrivileges.contains(privilege)){
				privilege.setChecked(true);
			}
		}
		return privileges;
	}

	public Collection<Privilege> getMenuitemsByUid(Integer uid) {
		return this.privilegeDao.getMenuitemsByUid(uid);
	}
	
}
