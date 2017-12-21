package com.neo.gyl.basedata.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neo.gyl.base.BaseAction;
import com.neo.gyl.basedata.service.DepartmentService;
import com.neo.gyl.basedata.service.UserService;
import com.neo.gyl.domain.basedata.Department;
import com.neo.gyl.domain.basedata.User;
import com.neo.gyl.query.UserQuery;
import com.neo.gyl.query.PageResult;
import com.opensymphony.xwork2.ActionContext;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	
	private UserQuery baseQuery = new UserQuery();
	
	/**
	 * 分页显示用户
	 */
	public String showPageResult() throws Exception {
		if(this.getCurrentPage() == null){
			this.setCurrentPage(1);
		}
		baseQuery.setCurrentPage(this.getCurrentPage());
		PageResult<User> pageResult = this.userService.getPageResult(baseQuery);
		ActionContext.getContext().put("pageResult", pageResult);
		return LISTACTION;
	}
	
	/**
	 * checkbox多行删除
	 */
	public String deleteUsers() throws Exception {
		if(StringUtils.isNotBlank(this.getCheckedStr())){
			this.userService.deleteEntriesByIds(this.getCheckedStr().split("\\,"));
		}
		return ACTION2ACTION;
	}
	
	/**
	 * 用户添加
	 */
	public String saveUI() throws Exception {
		Collection<Department> departments =  this.departmentService.getAllEntries();
		ActionContext.getContext().put("departments", departments);
		return SAVEUI;
	}
	public String save() throws Exception {
		User user = new User();
		BeanUtils.copyProperties(user, this.getModel());
		
		Department department = this.departmentService.getEntryById(this.did);
		user.setDepartment(department);
		
		this.userService.saveEntry(user);
		return ACTION2ACTION;
	}
	
	/**
	 * 用户更新
	 */
	public String updateUI() throws Exception {
		Collection<Department> departments =  this.departmentService.getAllEntries();
		ActionContext.getContext().put("departments", departments);
		
		User user = this.userService.getEntryById(this.getModel().getUid());
		ActionContext.getContext().getValueStack().push(user);
		return UPDATEUI;
	}
	
	private Integer did;
	
	
	
	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String update() throws Exception {
		User user = new User();
		BeanUtils.copyProperties(user, this.getModel());
		
		Department department = this.departmentService.getEntryById(this.did);
		user.setDepartment(department);
		
		this.userService.updateEntry(user);
		return ACTION2ACTION;
	}
	
	/**
	 * 用户删除
	 */
	public String delete() throws Exception {
		this.userService.deleteEntryById(this.getModel().getUid());
		return ACTION2ACTION;
	}
	
	
	
}
