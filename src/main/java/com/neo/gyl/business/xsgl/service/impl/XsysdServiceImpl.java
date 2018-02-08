package com.neo.gyl.business.xsgl.service.impl;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.neo.gyl.base.BaseDao;
import com.neo.gyl.business.base.service.BaseBusinessServiceImpl;
import com.neo.gyl.business.xsgl.dao.XsddzhibDao;
import com.neo.gyl.business.xsgl.dao.XsddzhubDao;
import com.neo.gyl.business.xsgl.dao.XsysdzhibDao;
import com.neo.gyl.business.xsgl.dao.XsysdzhubDao;
import com.neo.gyl.business.xsgl.service.XsysdService;
import com.neo.gyl.domain.business.xsgl.Xsddzhib;
import com.neo.gyl.domain.business.xsgl.Xsddzhub;
import com.neo.gyl.domain.business.xsgl.Xsysdzhib;
import com.neo.gyl.domain.business.xsgl.Xsysdzhub;
import com.neo.gyl.utils.GylContstantKey;

@Service("xsysdService")
public class XsysdServiceImpl extends BaseBusinessServiceImpl<Xsysdzhub, Xsysdzhib> implements XsysdService{

	@Resource(name="xsysdzhubDao")
	private XsysdzhubDao xsysdzhubDao;
	
	@Resource(name="xsysdzhibDao")
	private XsysdzhibDao xsysdzhibDao;
	
	@Resource(name="xsddzhibDao")
	private XsddzhibDao xsddzhibDao;
	
	@Resource(name="xsddzhubDao")
	private XsddzhubDao xsddzhubDao;
	
	@Override
	public BaseDao<Xsysdzhub> getBaseDao_zhub() {
		return this.xsysdzhubDao;
	}

	@Override
	public BaseDao<Xsysdzhib> getBaseDao_zhib() {
		return this.xsysdzhibDao;
	}
	
	public void saveXsysd(Xsysdzhub xsysdzhub, List<Xsysdzhib> xsysdzhibs) {
		for (Xsysdzhib xsysdzhib : xsysdzhibs) {
			String ytdjh = xsysdzhib.getYtdjh();
			Integer ythh = xsysdzhib.getYthh();
			
			Xsddzhib xsddzhib =  this.xsddzhibDao.getXsddzhibByCondition(ytdjh, ythh);
			Integer ljyssl = xsddzhib.getLjyssl();  //原累计应收数量
			
			xsysdzhib.setLjyssl(ljyssl + xsysdzhib.getSl());  //【销售应收单子表】设置累计应收数量
			xsddzhib.setLjyssl(ljyssl + xsysdzhib.getSl()); //【回写】【销售订单子表】设置累计应收数量
			
			if(xsddzhib.getLjyssl().intValue() == xsddzhib.getSl().intValue()){
				xsysdzhib.setIsysgb(true); //【销售应收单子表】设置应收关闭
				xsddzhib.setIsskjs(true); //【回写】【销售订单子表】设置收款结束
				xsddzhib.setHstatus(GylContstantKey.XSYSD_H_CLOSE);//【回写】【销售订单子表】设置行关闭
				
				List<Xsddzhib> xsddzhibs = this.xsddzhubDao.getXsddzhibsByDdh(ytdjh);
				boolean flag = true;
				for (Xsddzhib xsddzhib2 : xsddzhibs) {
					if(!GylContstantKey.XSYSD_H_CLOSE.equals(xsddzhib2.getHstatus())){
						flag = false;
						break;
					}
				}
				//销售订单子表中的所有的行全部关闭了
				if(flag){
					Xsddzhub xsddzhub = this.xsddzhubDao.getXsddzhubByDdh(ytdjh);
					//根据源头单据号设置销售订单的主表状态为关闭
					xsddzhub.setState(GylContstantKey.XSDDZHUB_H_STATE_CLOSE);
				}
			}
		}
		xsysdzhub.setXsysdzhibs(new HashSet<Xsysdzhib>(xsysdzhibs));
		this.xsysdzhubDao.saveEntry(xsysdzhub);
	}

	

}
