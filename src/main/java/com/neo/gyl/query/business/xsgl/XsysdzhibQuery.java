package com.neo.gyl.query.business.xsgl;

import java.util.Map;

import com.neo.gyl.query.BaseQuery;

public class XsysdzhibQuery extends BaseQuery {

	private Long xsysdzhubid;

	public Long getXsysdzhubid() {
		return xsysdzhubid;
	}

	public void setXsysdzhubid(Long xsysdzhubid) {
		this.xsysdzhubid = xsysdzhubid;
	}

	@Override
	public Map<String, Object> buildConditionMap() {
		if (xsysdzhubid != null) {
			this.getConditionMap().put("xsysdzhub.xsysdzhubid", this.xsysdzhubid);
		}
		return this.getConditionMap();
	}
}
