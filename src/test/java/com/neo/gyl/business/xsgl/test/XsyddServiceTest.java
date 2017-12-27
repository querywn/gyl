package com.neo.gyl.business.xsgl.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neo.gyl.business.xsgl.service.XsyddService;
import com.neo.gyl.domain.business.xsgl.Xsyddzhib;
import com.neo.gyl.domain.business.xsgl.Xsyddzhub;
import com.neo.gyl.query.PageResult;
import com.neo.gyl.query.business.xsgl.XsyddzhibQuery;
import com.neo.gyl.query.business.xsgl.XsyddzhubQuery;

public class XsyddServiceTest {
	
	@Test
	public void testZhub(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/neo/gyl/spring/applicationContext.xml");
		XsyddService xsyddService = (XsyddService) context.getBean("xsyddService");
		XsyddzhubQuery baseQuery = new XsyddzhubQuery();
		//baseQuery.setPageSize(2);
		//baseQuery.setCurrentPage(1);
		//baseQuery.setKhmc("111");
		PageResult<Xsyddzhub>  pageResult = xsyddService.getPageResult_zhub(baseQuery);
		System.out.println(pageResult.getRows());
	}
	
	@Test
	public void testZhib(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/neo/gyl/spring/applicationContext.xml");
		XsyddService xsyddService = (XsyddService) context.getBean("xsyddService");
		XsyddzhibQuery baseQuery = new XsyddzhibQuery();
		baseQuery.setXsyddzhubid(1);
		//baseQuery.setCurrentPage(1);  //主表id是1的第一页  2个结果
		//baseQuery.setCurrentPage(2); //主表id是1的第二页    1个结果
		PageResult<Xsyddzhib>  pageResult = xsyddService.getPageResult_zhib(baseQuery);
		System.out.println(pageResult.getRows());
	}
	
}
