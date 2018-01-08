package com.neo.gyl.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.neo.gyl.base.hibernatecallback.PageDataHibernateCallback;
import com.neo.gyl.base.hibernatecallback.ScalerHibernateCallback;
import com.neo.gyl.query.BaseQuery;
import com.neo.gyl.query.PageResult;
import com.neo.gyl.utils.GylUtils;

public class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	private Class<T> clazz;
	private ClassMetadata classMetadata;
	
	public BaseDaoImpl(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) type.getActualTypeArguments()[0];
	}
	
	@PostConstruct
	public void init(){
		this.classMetadata = this.hibernateTemplate.getSessionFactory().getClassMetadata(this.clazz);
	}
	
	public void saveEntry(T t) {
		this.hibernateTemplate.save(t);
	}

	public void updateEntry(T t) {
		this.hibernateTemplate.update(t);
	}

	public void deleteEntryById(Serializable id) {
		T t = this.getEntryById(id);
		this.hibernateTemplate.delete(t);
	}

	public T getEntryById(Serializable id) {
		return this.hibernateTemplate.get(this.clazz, id);
	}

	public Collection<T> getAllEntries() {
		return this.hibernateTemplate.find("from " + this.clazz.getSimpleName());
	}

	public void deleteEntriesByIds(Serializable[] ids) {
		Collection<T> entries = this.getEntriesByIds(ids);
		this.hibernateTemplate.deleteAll(entries);
	}

	public Collection<T> getEntriesByIds(Serializable[] ids) {
		String hql = "from " + this.clazz.getSimpleName() + " where " + this.classMetadata.getIdentifierPropertyName() + " in " + Arrays.toString(ids).replace("[", "(").replace("]", ")");
		return this.hibernateTemplate.find(hql);
	}

	public int getCount(BaseQuery baseQuery) {
		return this.hibernateTemplate.execute(new ScalerHibernateCallback(clazz, classMetadata, baseQuery));
	}

	public PageResult<T> getPageResult(BaseQuery baseQuery) {
		int totalRows = this.getCount(baseQuery);
		PageResult<T> pageResult = new PageResult<T>(baseQuery.getCurrentPage(), baseQuery.getPageSize(), totalRows);
		List<T> list = this.hibernateTemplate.execute(new PageDataHibernateCallback<T>(clazz, baseQuery));
		pageResult.setRows(list);
		return pageResult;
	}
	
	//获取最大的订单号  2018010800001
	public String getMaxDDH() {
		String currentDateString = GylUtils.getCurrentDateString();
		List list = this.hibernateTemplate.find("select max(ddh) from " + this.clazz.getSimpleName() + " where ddh like '%"+currentDateString+"%'");
		if(list==null || list.size()<1 || list.get(0)==null){
			return currentDateString + "00001";
		} else {
			String temp = (String) list.get(0);
			return String.valueOf(Long.parseLong(temp) + 1);
		}
	}
}
