package com.neo.gyl.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import com.neo.gyl.base.BaseDaoImpl;
import com.neo.gyl.basedata.dao.ProductDao;
import com.neo.gyl.domain.basedata.Product;

@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao{

}
