package com.neo.gyl.business.xsgl.service.impl;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neo.gyl.base.BaseDao;
import com.neo.gyl.business.base.service.BaseBusinessServiceImpl;
import com.neo.gyl.business.xsgl.dao.XsckdzhibDao;
import com.neo.gyl.business.xsgl.dao.XsckdzhubDao;
import com.neo.gyl.business.xsgl.dao.XsddzhibDao;
import com.neo.gyl.business.xsgl.service.XsckdService;
import com.neo.gyl.domain.business.xsgl.Xsckdzhib;
import com.neo.gyl.domain.business.xsgl.Xsckdzhub;
import com.neo.gyl.domain.business.xsgl.Xsddzhib;

@Service("xsckdService")
public class XsckdServiceImpl extends BaseBusinessServiceImpl<Xsckdzhub,Xsckdzhib> implements XsckdService{

	@Resource(name="xsckdzhubDao")
	private XsckdzhubDao xsckdzhubDao;
	
	@Resource(name="xsckdzhibDao")
	private XsckdzhibDao xsckdzhibDao;
	
	@Resource(name="xsddzhibDao")
	private XsddzhibDao xsddzhibDao;
	
	@Override
	public BaseDao<Xsckdzhub> getBaseDao_zhub() {
		return this.xsckdzhubDao;
	}

	@Override
	public BaseDao<Xsckdzhib> getBaseDao_zhib() {
		return this.xsckdzhibDao;
	}
	
	@Transactional
	public void saveXsckd(Xsckdzhub xsckdzhub, List<Xsckdzhib> xsckdzhibs) {
		for (Xsckdzhib xsckdzhib : xsckdzhibs) {
			String ytdjh = xsckdzhib.getYtdjh(); //源头单据号
			Integer ythh = xsckdzhib.getYthh();  //源头行号
			Xsddzhib xsddzhib = this.xsddzhibDao.getXsddzhibByCondition(ytdjh, ythh);
			Integer ljcksl = xsddzhib.getLjcksl(); //累计出库数量
			
			xsckdzhib.setLjcksl(ljcksl + xsckdzhib.getSfsl()); //【销售出库子表】设置累计出库数量
			xsddzhib.setLjcksl(xsckdzhib.getLjcksl());//【销售订单子表】设置累计出库数量（回写）
			
			//xsddzhib.getSl() 需要发货的数量
			//xsckdzhib.getLjcksl()  销售出库单的累计出库数量
			if(xsddzhib.getSl().intValue() == xsckdzhib.getLjcksl().intValue()){
				xsckdzhib.setIsckgb(true); //【销售出库但子表】设置发货关闭
				xsddzhib.setIsckgb(true); //【销售订单子表】设置发货关闭（回写）
			}
		}
		//保存
		xsckdzhub.setXsckdzhibs(new HashSet<Xsckdzhib>(xsckdzhibs));
		this.xsckdzhubDao.saveEntry(xsckdzhub);
	}

}
