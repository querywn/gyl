package com.neo.gyl.base.hibernatecallback;

import java.sql.SQLException;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.neo.gyl.query.BaseQuery;

public class ScalerHibernateCallback implements HibernateCallback<Integer> {

	private Class<?> clazz;
	private ClassMetadata classMetadata;
	private BaseQuery baseQuery;

	public ScalerHibernateCallback(Class<?> clazz, ClassMetadata classMetadata,
			BaseQuery baseQuery) {
		super();
		this.clazz = clazz;
		this.classMetadata = classMetadata;
		this.baseQuery = baseQuery;
	}

	public Integer doInHibernate(Session session) throws HibernateException,
			SQLException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select count("+this.classMetadata.getIdentifierPropertyName()+")");
		stringBuilder.append(" from " + this.clazz.getSimpleName());
		stringBuilder.append(" where 1=1 ");
		Map<String, Object> conditionMap = baseQuery.buildConditionMap();
		for (Map.Entry<String, Object> entry : conditionMap.entrySet()) {
			stringBuilder.append(" and " + entry.getKey() +"=:" + entry.getKey());
		}
		Query query = session.createQuery(stringBuilder.toString());
		for (Map.Entry<String, Object> entry : conditionMap.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return ((Long)query.uniqueResult()).intValue();
	}

}
