package com.neo.gyl.basedata.action;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neo.gyl.base.BaseAction;
import com.neo.gyl.basedata.service.DepartmentService;
import com.neo.gyl.domain.basedata.Department;
import com.neo.gyl.privilege.annotation.Permission;
import com.neo.gyl.query.DepartmentQuery;
import com.neo.gyl.query.PageResult;
import com.opensymphony.xwork2.ActionContext;

@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	
	private DepartmentQuery baseQuery = new DepartmentQuery();
	
	/**
	 * 分页显示部门
	 */
	@Permission(name="部门查询")
	public String showPageResult() throws Exception {
		if(this.getCurrentPage() == null){
			this.setCurrentPage(1);
		}
		baseQuery.setCurrentPage(this.getCurrentPage());
		PageResult<Department> pageResult = this.departmentService.getPageResult(baseQuery);
		ActionContext.getContext().put("pageResult", pageResult);
		return LISTACTION;
	}
	
	/**
	 * checkbox多行删除
	 */
	public String deleteDepartments() throws Exception {
		if(StringUtils.isNotBlank(this.getCheckedStr())){
			this.departmentService.deleteEntriesByIds(this.getCheckedStr().split("\\,"));
		}
		return ACTION2ACTION;
	}
	
	/**
	 * 部门添加
	 */
	public String saveUI() throws Exception {
		return SAVEUI;
	}
	public String save() throws Exception {
		Department department = new Department();
		BeanUtils.copyProperties(department, this.getModel());
		this.departmentService.saveEntry(department);
		return ACTION2ACTION;
	}
	
	/**
	 * 部门更新
	 */
	public String updateUI() throws Exception {
		Department department = this.departmentService.getEntryById(this.getModel().getDid());
		ActionContext.getContext().getValueStack().push(department);
		return UPDATEUI;
	}
	
	public String update() throws Exception {
		Department department = new Department();
		BeanUtils.copyProperties(department, this.getModel());
		this.departmentService.updateEntry(department);
		return ACTION2ACTION;
	}
	
	/**
	 * 部门删除
	 */
	public String delete() throws Exception {
		this.departmentService.deleteEntryById(this.getModel().getDid());
		return ACTION2ACTION;
	}
	
}
