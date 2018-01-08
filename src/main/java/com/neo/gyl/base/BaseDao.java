package com.neo.gyl.base;

import java.io.Serializable;
import java.util.Collection;

import com.neo.gyl.query.BaseQuery;
import com.neo.gyl.query.PageResult;

public interface BaseDao<T> {
	public void saveEntry(T t);
	public void updateEntry(T t);
	public void deleteEntryById(Serializable id);
	public T getEntryById(Serializable id);
	public Collection<T> getAllEntries();
	
	public void deleteEntriesByIds(Serializable[] ids);
	public Collection<T> getEntriesByIds(Serializable[] ids);
	
	public int getCount(BaseQuery baseQuery);
	public PageResult<T> getPageResult(BaseQuery baseQuery);
	
	//获取最大的订单号  2018010800001
	public String getMaxDDH();
}
