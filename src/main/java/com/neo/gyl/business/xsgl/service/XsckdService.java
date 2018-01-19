package com.neo.gyl.business.xsgl.service;

import java.util.List;

import com.neo.gyl.business.base.service.BaseBusinessService;
import com.neo.gyl.domain.business.xsgl.Xsckdzhib;
import com.neo.gyl.domain.business.xsgl.Xsckdzhub;

public interface XsckdService extends BaseBusinessService<Xsckdzhub, Xsckdzhib>{
	public void saveXsckd(Xsckdzhub xsckdzhub, List<Xsckdzhib> xsckdzhibs);
}
