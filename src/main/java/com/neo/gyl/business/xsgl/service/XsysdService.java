package com.neo.gyl.business.xsgl.service;

import java.util.List;

import com.neo.gyl.business.base.service.BaseBusinessService;
import com.neo.gyl.domain.business.xsgl.Xsysdzhib;
import com.neo.gyl.domain.business.xsgl.Xsysdzhub;

public interface XsysdService extends BaseBusinessService<Xsysdzhub, Xsysdzhib>{
	public void saveXsysd(Xsysdzhub xsysdzhub, List<Xsysdzhib> xsysdzhibs);
}
