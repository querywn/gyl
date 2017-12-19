package com.neo.gyl.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.neo.gyl.base.BaseDao;
import com.neo.gyl.base.BaseServiceImpl;
import com.neo.gyl.basedata.dao.DepartmentDao;
import com.neo.gyl.basedata.service.DepartmentService;
import com.neo.gyl.domain.basedata.Department;

@Service("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService{

	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;
	
	@Override
	public BaseDao<Department> getBaseDao() {
		return this.departmentDao;
	}
	
}
