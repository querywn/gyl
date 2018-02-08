package com.neo.gyl.business.xsgl.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.neo.gyl.base.BaseDaoImpl;
import com.neo.gyl.business.xsgl.dao.XsddzhubDao;
import com.neo.gyl.domain.business.xsgl.Xsddzhib;
import com.neo.gyl.domain.business.xsgl.Xsddzhub;

@Repository("xsddzhubDao")
public class XsddzhubDaoImpl extends BaseDaoImpl<Xsddzhub> implements XsddzhubDao{

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	public List<Xsddzhib> getXsddzhibsByDdh(String ytdjh) {
		return this.hibernateTemplate.find("from Xsddzhib where xsddzhub.ddh=?",ytdjh);
	}

	public Xsddzhub getXsddzhubByDdh(String ytdjh) {
		List<Xsddzhub> list = this.hibernateTemplate.find("from Xsddzhub where ddh=?",ytdjh);
		return (list==null || list.size()<1)?null:list.get(0);
	}
	
}
