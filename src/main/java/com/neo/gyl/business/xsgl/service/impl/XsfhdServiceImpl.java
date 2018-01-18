package com.neo.gyl.business.xsgl.service.impl;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neo.gyl.base.BaseDao;
import com.neo.gyl.business.base.service.BaseBusinessServiceImpl;
import com.neo.gyl.business.xsgl.dao.XsddzhibDao;
import com.neo.gyl.business.xsgl.dao.XsfhdzhibDao;
import com.neo.gyl.business.xsgl.dao.XsfhdzhubDao;
import com.neo.gyl.business.xsgl.service.XsfhdService;
import com.neo.gyl.domain.business.xsgl.Xsddzhib;
import com.neo.gyl.domain.business.xsgl.Xsfhdzhib;
import com.neo.gyl.domain.business.xsgl.Xsfhdzhub;

@Service("xsfhdService")
public class XsfhdServiceImpl extends BaseBusinessServiceImpl<Xsfhdzhub, Xsfhdzhib> implements XsfhdService{

	@Resource(name="xsfhdzhubDao")
	private XsfhdzhubDao xsfhdzhubDao;
	
	@Resource(name="xsfhdzhibDao")
	private XsfhdzhibDao xsfhdzhibDao;
	
	@Resource(name="xsddzhibDao")
	private XsddzhibDao xsddzhibDao;
	
	@Override
	public BaseDao<Xsfhdzhub> getBaseDao_zhub() {
		return this.xsfhdzhubDao;
	}

	@Override
	public BaseDao<Xsfhdzhib> getBaseDao_zhib() {
		return this.xsfhdzhibDao;
	}
	
	@Transactional
	public void saveXsfhd(Xsfhdzhub xsfhdzhub, List<Xsfhdzhib> xsfhdzhibs){
		for (Xsfhdzhib xsfhdzhib : xsfhdzhibs) {
			String ytdjh = xsfhdzhib.getYtdjh(); //源头订单号
			Integer ythh = xsfhdzhib.getYthh(); //源头行号
			List<Xsfhdzhib> xsfhdzhibs2 = this.xsfhdzhibDao.getXsfhdzhibsByCondition(ytdjh, ythh);
			Integer ljfhsl = 0; //累计发货数量
			for (Xsfhdzhib xsfhdzhib2 : xsfhdzhibs2) {
				ljfhsl += xsfhdzhib2.getSfsl();
			}
			xsfhdzhib.setLjfhsl(ljfhsl + xsfhdzhib.getSfsl()); //【1】累计发货数量 = 之前的累计发货数量 + 当前发货子订单的实发数量
			
			//【回写】设置销售订单子表的累计发货数量
			Xsddzhib xsddzhib = this.xsddzhibDao.getXsddzhibByCondition(ytdjh, ythh);
			xsddzhib.setLjfhsl(xsfhdzhib.getLjfhsl());
			
			if(xsddzhib.getSl().intValue() == xsfhdzhib.getLjfhsl().intValue()){
				xsddzhib.setIsfhgb(true); //【回写】销售订单子表设置发货关闭
				xsfhdzhib.setIsfhgb(true);//[销售发货单子表]设置发货关闭
			}
		}
		//保存【销售发货单】
		xsfhdzhub.setXsfhdzhibs(new HashSet<Xsfhdzhib>(xsfhdzhibs));
		this.xsfhdzhubDao.saveEntry(xsfhdzhub);
	}

}
