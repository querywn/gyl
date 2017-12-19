package com.neo.gyl.base.hibernatecallback;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.neo.gyl.query.BaseQuery;

public class PageDataHibernateCallback<T> implements HibernateCallback<List<T>> {

	private Class<?> clazz;
	private BaseQuery baseQuery;

	public PageDataHibernateCallback(Class<?> clazz, BaseQuery baseQuery) {
		super();
		this.clazz = clazz;
		this.baseQuery = baseQuery;
	}

	public List<T> doInHibernate(Session session) throws HibernateException,
			SQLException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("from " + this.clazz.getSimpleName());
		stringBuilder.append(" where 1=1 ");
		Map<String, Object> conditionMap = baseQuery.buildConditionMap();
		for (Map.Entry<String, Object> entry : conditionMap.entrySet()) {
			stringBuilder.append(" and " + entry.getKey() +"=:" + entry.getKey());
		}
		Query query = session.createQuery(stringBuilder.toString());
		for (Map.Entry<String, Object> entry : conditionMap.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		
		return query.list();
	}

}
