package com.neo.gyl.basedata.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neo.gyl.base.BaseAction;
import com.neo.gyl.basedata.service.DepartmentService;
import com.neo.gyl.domain.basedata.Department;
import com.neo.gyl.query.DepartmentQuery;
import com.neo.gyl.query.PageResult;
import com.opensymphony.xwork2.ActionContext;

@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	
	private DepartmentQuery baseQuery = new DepartmentQuery();
	
	public String showPageResult() throws Exception {
		PageResult<Department> pageResult = this.departmentService.getPageResult(baseQuery);
		ActionContext.getContext().put("pageResult", pageResult);
		return LISTACTION;
	}
	
}
