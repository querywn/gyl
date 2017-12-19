package com.neo.gyl.base;

import java.io.Serializable;
import java.util.Collection;

import com.neo.gyl.query.BaseQuery;
import com.neo.gyl.query.PageResult;

public interface BaseService<T> {
	public void saveEntry(T t);
	public void updateEntry(T t);
	public void deleteEntryById(Serializable id);
	public T getEntryById(Serializable id);
	public Collection<T> getAllEntries();
	
	public void deleteEntriesByIds(Serializable[] ids);
	public Collection<T> getEntriesByIds(Serializable[] ids);
	
	public PageResult<T> getPageResult(BaseQuery baseQuery);
}
