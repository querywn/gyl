package com.neo.gyl.basedata.test;

import java.io.Serializable;
import java.util.Collection;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neo.gyl.basedata.service.DepartmentService;
import com.neo.gyl.domain.basedata.Department;
import com.neo.gyl.query.BaseQuery;
import com.neo.gyl.query.DepartmentQuery;
import com.neo.gyl.query.PageResult;

public class DepartmentServiceImplTest {

	private static DepartmentService departmentService;
	
	static {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/neo/gyl/spring/applicationContext.xml");
		departmentService = (DepartmentService) context.getBean("departmentService");
	}
	
	@Test
	public void testSaveEntry() {
		Department department = new Department();
		department.setName("研发部");
		department.setDescription("研发部Aaa");
		departmentService.saveEntry(department);
	}

	@Test
	public void testUpdateEntry() {
		Department department = departmentService.getEntryById(1);
		department.setDescription("负责项目研发");
		departmentService.updateEntry(department);
	}

	@Test
	public void testDeleteEntry() {
		departmentService.deleteEntryById(2);
	}

	@Test
	public void testGetEntryById() {
		Department department = departmentService.getEntryById(1);
		System.out.println(department);
	}

	@Test
	public void testGetAllEntry() {
		Collection<Department> departments = departmentService.getAllEntries();
		System.out.println(departments);
	}

	@Test
	public void testGetEntriesByIds() {
		Serializable[] ids = {1,2,3};
		Collection<Department>  departments =  departmentService.getEntriesByIds(ids);
		System.out.println(departments);
	}

	@Test
	public void testDeleteEntriesByIDS() {
		Serializable[] ids = {5,6};
		departmentService.deleteEntriesByIds(ids);
	}

	@Test
	public void testGetPageResult(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/neo/gyl/spring/applicationContext.xml");
		DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
		BaseQuery baseQuery = new DepartmentQuery();
		PageResult<Department> pageResult = departmentService.getPageResult(baseQuery);
		System.out.println(pageResult.getRows().size());
		context.close();
	}
}

