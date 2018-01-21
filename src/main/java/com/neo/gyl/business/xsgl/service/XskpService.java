package com.neo.gyl.business.xsgl.service;

import java.util.List;

import com.neo.gyl.domain.business.xsgl.Xskpzhib;
import com.neo.gyl.domain.business.xsgl.Xskpzhub;

public interface XskpService {
	public void saveXskp(Xskpzhub xskpzhub, List<Xskpzhib> xskpzhibs);
}
