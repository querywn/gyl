package com.neo.gyl.business.xsgl.dao;

import java.util.List;

import com.neo.gyl.base.BaseDao;
import com.neo.gyl.domain.business.xsgl.Xsddzhib;
import com.neo.gyl.domain.business.xsgl.Xsddzhub;

public interface XsddzhubDao extends BaseDao<Xsddzhub>{
	public List<Xsddzhib> getXsddzhibsByDdh(String ytdjh);
	public Xsddzhub getXsddzhubByDdh(String ytdjh);
}
