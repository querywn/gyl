package com.neo.gyl.privilege.dao.impl;


import java.util.Collection;
import java.util.HashSet;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.neo.gyl.base.BaseDaoImpl;
import com.neo.gyl.domain.privilege.Privilege;
import com.neo.gyl.privilege.dao.PrivilegeDao;

@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao{

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	public Collection<Privilege> getPrivilegesByRid(Integer rid) {
		return this.hibernateTemplate.find("from Privilege p inner join fetch p.roles r where r.rid=?",rid);
	}

	public Collection<Privilege> getMenuitemsByUid(Integer uid) {
		if(uid == 1){
			String hql = "from Privilege where type='1'";
			return new HashSet<Privilege>(this.hibernateTemplate.find(hql));
		} else {
			String hql = "from Privilege p inner join fetch p.roles r inner join fetch r.users u where u.uid=? and p.type='1'";
			return new HashSet<Privilege>(this.hibernateTemplate.find(hql, uid));
		}
	}

	public Collection<Privilege> getFunctionsByUid(Integer uid) {
		if(uid == 1){
			String hql = "from Privilege where type='2'";
			return new HashSet<Privilege>(this.hibernateTemplate.find(hql));
		} else {
			String hql = "from Privilege p inner join fetch p.roles r inner join fetch r.users u where u.uid=? and p.type='2'";
			return new HashSet<Privilege>(this.hibernateTemplate.find(hql, uid));
		}
	}

}
