package com.neo.gyl.business.xsgl.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neo.gyl.business.xsgl.dao.XsddzhibDao;
import com.neo.gyl.business.xsgl.service.XskpService;
import com.neo.gyl.domain.business.xsgl.Xsddzhib;
import com.neo.gyl.domain.business.xsgl.Xskpzhib;
import com.neo.gyl.domain.business.xsgl.Xskpzhub;

public class XskpTest {
	
	@Test
	public void testSave(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/neo/gyl/spring/applicationContext.xml");
		XskpService xskpService = (XskpService)context.getBean("xskpService");
		Xskpzhub xskpzhub = new Xskpzhub();
		List<Xskpzhib> xskpzhibs = new ArrayList<Xskpzhib>();
		Xskpzhib xskpzhib = new Xskpzhib();
		xskpzhib.setSl(20);//设置实发数量
		xskpzhib.setHsje(2000f);  //设置含税金额
		xskpzhib.setYtdjh("2018011000001");//源头单据号
		xskpzhib.setYthh(1);//源头行号
		xskpzhibs.add(xskpzhib);
		xskpService.saveXskp(xskpzhub, xskpzhibs);
		
		System.out.println("销售开票子表是否关闭："+xskpzhib.getIskpjs());
		XsddzhibDao xsddzhibDao = (XsddzhibDao)context.getBean("xsddzhibDao");
		Xsddzhib xsddzhib = xsddzhibDao.getXsddzhibByCondition("2018011000001", 1);
		System.out.println("销售订单子表累计开票数量:"+xsddzhib.getLjkpsl());
		System.out.println("是否开票关闭:"+xsddzhib.getIskpgb());
	}
	
	//分两次发货，每次实发数量为10 (执行两次)
	@Test
	public void testSaveTwice(){
		/*
		ApplicationContext context = new ClassPathXmlApplicationContext("com/neo/gyl/spring/applicationContext.xml");
		XskpzhubDao xskpzhubDao = (XskpzhubDao) context.getBean("xskpzhubDao");
		xskpzhubDao.saveEntry(xskpzhub);
		 */
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/neo/gyl/spring/applicationContext.xml");
		XskpService xskpService = (XskpService)context.getBean("xskpService");
		Xskpzhub xskpzhub = new Xskpzhub();
		List<Xskpzhib> xskpzhibs = new ArrayList<Xskpzhib>();
		
		Xskpzhib xskpzhib = new Xskpzhib();
		xskpzhib.setSl(10);;//设置实发数量
		xskpzhib.setHsje(2000f); //设置含税金额
		xskpzhib.setYtdjh("2018011000001");//源头单据号
		xskpzhib.setYthh(1);//源头行号
		xskpzhibs.add(xskpzhib);
		
		xskpService.saveXskp(xskpzhub, xskpzhibs);
		
		System.out.println("销售开票子表是否关闭："+xskpzhib.getIskpjs());
		XsddzhibDao xsddzhibDao = (XsddzhibDao)context.getBean("xsddzhibDao");
		Xsddzhib xsddzhib = xsddzhibDao.getXsddzhibByCondition("2018011000001", 1);
		System.out.println("销售订单子表累计开票数量:"+xsddzhib.getLjkpsl());
		System.out.println("是否开票关闭:"+xsddzhib.getIskpgb());
	}
	
}
