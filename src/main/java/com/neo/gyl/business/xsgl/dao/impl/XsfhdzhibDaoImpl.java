package com.neo.gyl.business.xsgl.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.neo.gyl.base.BaseDaoImpl;
import com.neo.gyl.business.xsgl.dao.XsfhdzhibDao;
import com.neo.gyl.domain.business.xsgl.Xsfhdzhib;

@Repository("xsfhdzhibDao")
public class XsfhdzhibDaoImpl extends BaseDaoImpl<Xsfhdzhib> implements XsfhdzhibDao{

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	public List<Xsfhdzhib> getXsfhdzhibsByCondition(String ytdjh, Integer ythh) {
		return this.hibernateTemplate.find("from Xsfhdzhib where xsfhdzhub.ddh=? and ythh=?", ytdjh, ythh);
	}

}
