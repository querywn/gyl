package com.neo.gyl.business.xsgl.dao;

import com.neo.gyl.base.BaseDao;
import com.neo.gyl.domain.business.xsgl.Xsddzhib;

public interface XsddzhibDao extends BaseDao<Xsddzhib>{
	public Xsddzhib getXsddzhibByCondition(String ytdjh, Integer ythh);
}
