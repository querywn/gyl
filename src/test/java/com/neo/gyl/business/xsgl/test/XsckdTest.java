package com.neo.gyl.business.xsgl.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neo.gyl.business.xsgl.dao.XsddzhibDao;
import com.neo.gyl.business.xsgl.service.XsckdService;
import com.neo.gyl.domain.business.xsgl.Xsddzhib;
import com.neo.gyl.domain.business.xsgl.Xsckdzhib;
import com.neo.gyl.domain.business.xsgl.Xsckdzhub;

public class XsckdTest {
	
	@Test
	public void testSave(){
		/*
		ApplicationContext context = new ClassPathXmlApplicationContext("com/neo/gyl/spring/applicationContext.xml");
		XsckdzhubDao xsckdzhubDao = (XsckdzhubDao) context.getBean("xsckdzhubDao");
		xsckdzhubDao.saveEntry(xsckdzhub);
		 */
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/neo/gyl/spring/applicationContext.xml");
		XsckdService xsckdService = (XsckdService)context.getBean("xsckdService");
		Xsckdzhub xsckdzhub = new Xsckdzhub();
		List<Xsckdzhib> xsckdzhibs = new ArrayList<Xsckdzhib>();
		Xsckdzhib xsckdzhib = new Xsckdzhib();
		xsckdzhib.setSfsl(20);//设置实发数量
		xsckdzhib.setYtdjh("2018011000001");//源头单据号
		xsckdzhib.setYthh(1);//源头行号
		xsckdzhibs.add(xsckdzhib);
		xsckdService.saveXsckd(xsckdzhub, xsckdzhibs);
		
		System.out.println("销售发货单子表是否关闭："+xsckdzhib.getIsckgb());
		XsddzhibDao xsddzhibDao = (XsddzhibDao)context.getBean("xsddzhibDao");
		Xsddzhib xsddzhib = xsddzhibDao.getXsddzhibByCondition("2018011000001", 1);
		System.out.println("销售订单子表累计发货数量:"+xsddzhib.getLjcksl());
		System.out.println("是否发货关闭:"+xsddzhib.getIsckgb());
	}
	
	//分两次发货，每次实发数量为10 (执行两次)
	@Test
	public void testSaveTwice(){
		/*
		ApplicationContext context = new ClassPathXmlApplicationContext("com/neo/gyl/spring/applicationContext.xml");
		XsckdzhubDao xsckdzhubDao = (XsckdzhubDao) context.getBean("xsckdzhubDao");
		xsckdzhubDao.saveEntry(xsckdzhub);
		 */
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/neo/gyl/spring/applicationContext.xml");
		XsckdService xsckdService = (XsckdService)context.getBean("xsckdService");
		Xsckdzhub xsckdzhub = new Xsckdzhub();
		List<Xsckdzhib> xsckdzhibs = new ArrayList<Xsckdzhib>();
		
		Xsckdzhib xsckdzhib = new Xsckdzhib();
		xsckdzhib.setSfsl(10);//设置实发数量
		xsckdzhib.setYtdjh("2018011000001");//源头单据号
		xsckdzhib.setYthh(1);//源头行号
		xsckdzhibs.add(xsckdzhib);
		
		xsckdService.saveXsckd(xsckdzhub, xsckdzhibs);
		
		System.out.println("销售发货单子表是否关闭："+xsckdzhib.getIsckgb());
		XsddzhibDao xsddzhibDao = (XsddzhibDao)context.getBean("xsddzhibDao");
		Xsddzhib xsddzhib = xsddzhibDao.getXsddzhibByCondition("2018011000001", 1);
		System.out.println("销售订单子表累计发货数量:"+xsddzhib.getLjcksl());
		System.out.println("是否发货关闭:"+xsddzhib.getIsckgb());
	}
	
}
