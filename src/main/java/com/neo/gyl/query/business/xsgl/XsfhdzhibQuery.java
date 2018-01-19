package com.neo.gyl.query.business.xsgl;

import java.util.Map;

import com.neo.gyl.query.BaseQuery;


public class XsfhdzhibQuery extends BaseQuery {
	private Long xsfhdzhubid;

	public Long getXsfhdzhubid() {
		return xsfhdzhubid;
	}
	public void setXsfhdzhubid(Long xsfhdzhubid) {
		this.xsfhdzhubid = xsfhdzhubid;
	}
	
	
	@Override
	public Map<String, Object> buildConditionMap() {
		if (xsfhdzhubid != null) {
			this.getConditionMap().put("xsfhdzhub.xsfhdzhubid", this.xsfhdzhubid);
		}
		return this.getConditionMap();
	}
}
