package com.neo.gyl.query;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseQuery {
	
	private Integer currentPage = 1;
	private Integer pageSize = 2;
	private Map<String, Object> conditionMap = new HashMap<String, Object>();
	public abstract Map<String, Object> buildConditionMap();
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Map<String, Object> getConditionMap() {
		return conditionMap;
	}
	public void setConditionMap(Map<String, Object> conditionMap) {
		this.conditionMap = conditionMap;
	}
	
}
