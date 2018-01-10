package com.neo.gyl.business.xsgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.neo.gyl.base.BaseDao;
import com.neo.gyl.business.base.service.BaseBusinessServiceImpl;
import com.neo.gyl.business.xsgl.dao.XsddzhibDao;
import com.neo.gyl.business.xsgl.dao.XsddzhubDao;
import com.neo.gyl.business.xsgl.service.XsddService;
import com.neo.gyl.domain.business.xsgl.Xsddzhib;
import com.neo.gyl.domain.business.xsgl.Xsddzhub;

@Service("xsddService")
public class XsddServiceImpl extends BaseBusinessServiceImpl<Xsddzhub, Xsddzhib> implements XsddService{
	
	@Resource(name="xsddzhubDao")
	private XsddzhubDao xsddzhubDao;
	
	@Resource(name="xsddzhibDao")
	private XsddzhibDao xsddzhibDao;
	
	@Override
	public BaseDao<Xsddzhub> getBaseDao_zhub() {
		return this.xsddzhubDao;
	}

	@Override
	public BaseDao<Xsddzhib> getBaseDao_zhib() {
		return this.xsddzhibDao;
	}

}
