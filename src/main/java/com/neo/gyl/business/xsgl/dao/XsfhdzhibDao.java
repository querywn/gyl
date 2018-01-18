package com.neo.gyl.business.xsgl.dao;

import java.util.List;

import com.neo.gyl.base.BaseDao;
import com.neo.gyl.domain.business.xsgl.Xsfhdzhib;

public interface XsfhdzhibDao extends BaseDao<Xsfhdzhib>{
	public List<Xsfhdzhib> getXsfhdzhibsByCondition(String ytdjh, Integer ythh);
}
