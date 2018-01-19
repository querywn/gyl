package com.neo.gyl.business.xsgl.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neo.gyl.business.xsgl.dao.XsddzhibDao;
import com.neo.gyl.business.xsgl.service.XsfhdService;
import com.neo.gyl.domain.business.xsgl.Xsddzhib;
import com.neo.gyl.domain.business.xsgl.Xsfhdzhib;
import com.neo.gyl.domain.business.xsgl.Xsfhdzhub;

public class XsfhdTest {
	
	@Test
	public void testSave(){
		/*
		ApplicationContext context = new ClassPathXmlApplicationContext("com/neo/gyl/spring/applicationContext.xml");
		XsfhdzhubDao xsfhdzhubDao = (XsfhdzhubDao) context.getBean("xsfhdzhubDao");
		xsfhdzhubDao.saveEntry(xsfhdzhub);
		 */
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/neo/gyl/spring/applicationContext.xml");
		XsfhdService xsfhdService = (XsfhdService)context.getBean("xsfhdService");
		Xsfhdzhub xsfhdzhub = new Xsfhdzhub();
		List<Xsfhdzhib> xsfhdzhibs = new ArrayList<Xsfhdzhib>();
		Xsfhdzhib xsfhdzhib = new Xsfhdzhib();
		xsfhdzhib.setSfsl(20);//设置实发数量
		xsfhdzhib.setYtdjh("2018011000001");//源头单据号
		xsfhdzhib.setYthh(1);//源头行号
		xsfhdzhibs.add(xsfhdzhib);
		xsfhdService.saveXsfhd(xsfhdzhub, xsfhdzhibs);
		
		System.out.println("销售发货单子表是否关闭："+xsfhdzhib.getIsfhgb());
		XsddzhibDao xsddzhibDao = (XsddzhibDao)context.getBean("xsddzhibDao");
		Xsddzhib xsddzhib = xsddzhibDao.getXsddzhibByCondition("2018011000001", 1);
		System.out.println("销售订单子表累计发货数量:"+xsddzhib.getLjfhsl());
		System.out.println("是否发货关闭:"+xsddzhib.getIsfhgb());
	}
	
	//分两次发货，每次实发数量为10
	@Test
	public void testSaveTwice(){
		/*
		ApplicationContext context = new ClassPathXmlApplicationContext("com/neo/gyl/spring/applicationContext.xml");
		XsfhdzhubDao xsfhdzhubDao = (XsfhdzhubDao) context.getBean("xsfhdzhubDao");
		xsfhdzhubDao.saveEntry(xsfhdzhub);
		 */
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/neo/gyl/spring/applicationContext.xml");
		XsfhdService xsfhdService = (XsfhdService)context.getBean("xsfhdService");
		Xsfhdzhub xsfhdzhub = new Xsfhdzhub();
		List<Xsfhdzhib> xsfhdzhibs = new ArrayList<Xsfhdzhib>();
		
		Xsfhdzhib xsfhdzhib = new Xsfhdzhib();
		xsfhdzhib.setSfsl(10);//设置实发数量
		xsfhdzhib.setYtdjh("2018011000001");//源头单据号
		xsfhdzhib.setYthh(1);//源头行号
		xsfhdzhibs.add(xsfhdzhib);
		
		xsfhdService.saveXsfhd(xsfhdzhub, xsfhdzhibs);
		
		System.out.println("销售发货单子表是否关闭："+xsfhdzhib.getIsfhgb());
		XsddzhibDao xsddzhibDao = (XsddzhibDao)context.getBean("xsddzhibDao");
		Xsddzhib xsddzhib = xsddzhibDao.getXsddzhibByCondition("2018011000001", 1);
		System.out.println("销售订单子表累计发货数量:"+xsddzhib.getLjfhsl());
		System.out.println("是否发货关闭:"+xsddzhib.getIsfhgb());
	}
	
}
