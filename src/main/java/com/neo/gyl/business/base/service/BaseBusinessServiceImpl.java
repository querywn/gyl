package com.neo.gyl.business.base.service;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.neo.gyl.base.BaseDao;
import com.neo.gyl.business.xsgl.dao.XsyddzhibDao;
import com.neo.gyl.business.xsgl.dao.XsyddzhubDao;
import com.neo.gyl.query.BaseQuery;
import com.neo.gyl.query.PageResult;

public abstract class BaseBusinessServiceImpl<T extends Serializable, E extends Serializable> implements BaseBusinessService<T, E> {

	public abstract BaseDao<T> getBaseDao_zhub();
	public abstract BaseDao<E> getBaseDao_zhib();
	
	public PageResult<T> getPageResult_zhub(BaseQuery baseQuery) {
		return this.getBaseDao_zhub().getPageResult(baseQuery);
	}

	public PageResult<E> getPageResult_zhib(BaseQuery baseQuery) {
		return this.getBaseDao_zhib().getPageResult(baseQuery);
	}
	
	//获取最大的订单号  2018010800001
	public String getMaxDDH(){
		return this.getBaseDao_zhub().getMaxDDH();
	}

	//保存主表
	@Transactional
	public void saveEntry_zhub(T t){
		this.getBaseDao_zhub().saveEntry(t);
	}
}
