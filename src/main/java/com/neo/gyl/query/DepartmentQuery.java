package com.neo.gyl.query;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class DepartmentQuery extends BaseQuery {

	private String name;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Map<String, Object> buildConditionMap() {
		if(StringUtils.isNotBlank(name)){
			this.getConditionMap().put(name, name);
		}
		if(StringUtils.isNotBlank(description)){
			this.getConditionMap().put(description, description);
		}
		return this.getConditionMap();
	}

}
