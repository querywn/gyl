package com.neo.gyl.business.xsgl.service.impl;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neo.gyl.base.BaseDao;
import com.neo.gyl.business.base.service.BaseBusinessServiceImpl;
import com.neo.gyl.business.xsgl.dao.XsddzhibDao;
import com.neo.gyl.business.xsgl.dao.XskpzhibDao;
import com.neo.gyl.business.xsgl.dao.XskpzhubDao;
import com.neo.gyl.business.xsgl.service.XskpService;
import com.neo.gyl.domain.business.xsgl.Xsddzhib;
import com.neo.gyl.domain.business.xsgl.Xskpzhib;
import com.neo.gyl.domain.business.xsgl.Xskpzhub;

@Service("xskpService")
public class XskpServiceImpl extends BaseBusinessServiceImpl<Xskpzhub, Xskpzhib> implements XskpService{

	@Resource(name="xskpzhubDao")
	private XskpzhubDao xskpzhubDao;
	
	@Resource(name="xskpzhibDao")
	private XskpzhibDao xskpzhibDao;
	
	@Resource(name="xsddzhibDao")
	private XsddzhibDao xsddzhibDao;
	
	@Override
	public BaseDao<Xskpzhub> getBaseDao_zhub() {
		return this.xskpzhubDao;
	}

	@Override
	public BaseDao<Xskpzhib> getBaseDao_zhib() {
		return this.xskpzhibDao;
	}
	
	@Transactional
	public void saveXskp(Xskpzhub xskpzhub, List<Xskpzhib> xskpzhibs) {
		Float fpzje = xskpzhub.getFpzje(); //发票总金额
		for (Xskpzhib xskpzhib : xskpzhibs) {
			String ytdjh = xskpzhib.getYtdjh();  //源头单据号
			Integer ythh = xskpzhib.getYthh(); //源头行号
			Xsddzhib xsddzhib = this.xsddzhibDao.getXsddzhibByCondition(ytdjh, ythh);
			Integer ljkpsl = xsddzhib.getLjkpsl();
			xskpzhib.setLjkpsl(ljkpsl + xskpzhib.getSl()); //【销售开票单子表】设置累计开票数量
			xsddzhib.setLjkpsl(xskpzhib.getLjkpsl());//【回写】 【销售订单子表】设置累计开票数量
			if(xskpzhib.getLjkpsl().intValue() == xsddzhib.getSl().intValue()){
				xskpzhib.setIskpjs(true); //【销售开票单子表】设置开票结束
				xsddzhib.setIskpgb(true);//【回写】 【销售订单子表】设置开票关闭
			}
			fpzje += xskpzhib.getHsje(); 
		}
		xskpzhub.setFpzje(fpzje);
		//保存
		xskpzhub.setXskpzhibs(new HashSet<Xskpzhib>(xskpzhibs));
		this.xskpzhubDao.saveEntry(xskpzhub);
	}
	
}
