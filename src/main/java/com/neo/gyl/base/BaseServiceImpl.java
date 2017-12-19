package com.neo.gyl.base;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.neo.gyl.query.BaseQuery;
import com.neo.gyl.query.PageResult;

public abstract class BaseServiceImpl<T> implements BaseService<T>{
	public abstract BaseDao<T> getBaseDao();

	@Transactional
	public void saveEntry(T t) {
		this.getBaseDao().saveEntry(t);
	}
	
	@Transactional
	public void updateEntry(T t) {
		this.getBaseDao().updateEntry(t);
	}
	
	@Transactional
	public void deleteEntryById(Serializable id) {
		this.getBaseDao().deleteEntryById(id);
	}

	public T getEntryById(Serializable id) {
		return this.getBaseDao().getEntryById(id);
	}

	public Collection<T> getAllEntries() {
		return this.getBaseDao().getAllEntries();
	}

	@Transactional
	public void deleteEntriesByIds(Serializable[] ids) {
		this.getBaseDao().deleteEntriesByIds(ids);
	}

	public Collection<T> getEntriesByIds(Serializable[] ids) {
		return this.getBaseDao().getEntriesByIds(ids);
	}

	public PageResult<T> getPageResult(BaseQuery baseQuery) {
		return this.getBaseDao().getPageResult(baseQuery);
	}
	
	
}
