package com.neo.gyl.business.base.service;

import java.io.Serializable;

import com.neo.gyl.query.BaseQuery;
import com.neo.gyl.query.PageResult;

public interface BaseBusinessService<T extends Serializable,E extends Serializable> {
	public PageResult<T> getPageResult_zhub(BaseQuery baseQuery);
	public PageResult<E> getPageResult_zhib(BaseQuery baseQuery);
}
