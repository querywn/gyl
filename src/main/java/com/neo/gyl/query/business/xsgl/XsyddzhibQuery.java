package com.neo.gyl.query.business.xsgl;

import java.util.Map;
import com.neo.gyl.query.BaseQuery;


public class XsyddzhibQuery extends BaseQuery {
	
	private Integer xsyddzhubid;// 销售预订单主表ID
	

	public void setXsyddzhubid(Integer xsyddzhubid) {
		this.xsyddzhubid = xsyddzhubid;
	}

	@Override
	public Map<String, Object> buildConditionMap() {
		if (xsyddzhubid != null) {
			this.getConditionMap().put("xsyddzhub.xsyddzhubid", this.xsyddzhubid);
		}
		return this.getConditionMap();
	}
}
