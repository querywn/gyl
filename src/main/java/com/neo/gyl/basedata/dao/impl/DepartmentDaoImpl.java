package com.neo.gyl.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import com.neo.gyl.base.BaseDaoImpl;
import com.neo.gyl.basedata.dao.DepartmentDao;
import com.neo.gyl.domain.basedata.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao{

}
