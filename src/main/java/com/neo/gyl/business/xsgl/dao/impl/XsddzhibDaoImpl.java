package com.neo.gyl.business.xsgl.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.neo.gyl.base.BaseDaoImpl;
import com.neo.gyl.business.xsgl.dao.XsddzhibDao;
import com.neo.gyl.domain.business.xsgl.Xsddzhib;

@Repository("xsddzhibDao")
public class XsddzhibDaoImpl extends BaseDaoImpl<Xsddzhib> implements XsddzhibDao{

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	public Xsddzhib getXsddzhibByCondition(String ytdjh, Integer ythh) {
		List<Xsddzhib> list = this.hibernateTemplate.find("from Xsddzhib where xsddzhub.ddh=? and hh=?", ytdjh, ythh);
		return (list==null || list.size()<1) ? null:list.get(0);
	}

}
