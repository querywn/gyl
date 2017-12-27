package com.neo.gyl.business.xsgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.neo.gyl.base.BaseDao;
import com.neo.gyl.business.base.service.BaseBusinessServiceImpl;
import com.neo.gyl.business.xsgl.dao.XsyddzhibDao;
import com.neo.gyl.business.xsgl.dao.XsyddzhubDao;
import com.neo.gyl.business.xsgl.service.XsyddService;
import com.neo.gyl.domain.business.xsgl.Xsyddzhib;
import com.neo.gyl.domain.business.xsgl.Xsyddzhub;

@Service("xsyddService")
public class XsyddServiceImpl extends BaseBusinessServiceImpl<Xsyddzhub, Xsyddzhib> implements XsyddService{

	@Resource(name="xsyddzhubDao")
	private XsyddzhubDao xsyddzhubDao;
	
	@Resource(name="xsyddzhibDao")
	private XsyddzhibDao xsyddzhibDao;
	
	@Override
	public BaseDao<Xsyddzhub> getBaseDao_zhub() {
		return this.xsyddzhubDao;
	}

	@Override
	public BaseDao<Xsyddzhib> getBaseDao_zhib() {
		return this.xsyddzhibDao;
	}

}
