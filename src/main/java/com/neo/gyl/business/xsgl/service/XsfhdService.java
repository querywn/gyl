package com.neo.gyl.business.xsgl.service;

import java.util.List;

import com.neo.gyl.business.base.service.BaseBusinessService;
import com.neo.gyl.domain.business.xsgl.Xsfhdzhib;
import com.neo.gyl.domain.business.xsgl.Xsfhdzhub;

public interface XsfhdService extends BaseBusinessService<Xsfhdzhub, Xsfhdzhib>{
	public void saveXsfhd(Xsfhdzhub xsfhdzhub, List<Xsfhdzhib> xsfhdzhibs);
}
