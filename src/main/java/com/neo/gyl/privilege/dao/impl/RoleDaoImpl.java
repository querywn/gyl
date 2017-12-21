package com.neo.gyl.privilege.dao.impl;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.neo.gyl.base.BaseDaoImpl;
import com.neo.gyl.domain.privilege.Role;
import com.neo.gyl.privilege.dao.RoleDao;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	public Role getByName(final String name) {
		return this.hibernateTemplate.execute(new HibernateCallback<Role>() {
			public Role doInHibernate(Session session)
					throws HibernateException, SQLException {
				return (Role) session.createQuery("from Role where name=:name")
						.setParameter("name", name)
						.uniqueResult();
			}
		});
	}

}
