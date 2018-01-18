package com.neo.gyl.business.base.service;

import java.io.Serializable;

import com.neo.gyl.query.BaseQuery;
import com.neo.gyl.query.PageResult;

public interface BaseBusinessService<T extends Serializable,E extends Serializable> {
	public PageResult<T> getPageResult_zhub(BaseQuery baseQuery);
	public PageResult<E> getPageResult_zhib(BaseQuery baseQuery);
	//获取最大的订单号  2018010800001
	public String getMaxDDH();
	//保存主表
	public void saveEntry_zhub(T t);
	//根据id获取主表
	public T getEntryById_zhub(Serializable id);
}
