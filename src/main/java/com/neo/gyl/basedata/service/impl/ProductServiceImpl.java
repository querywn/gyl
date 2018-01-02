package com.neo.gyl.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.neo.gyl.base.BaseDao;
import com.neo.gyl.base.BaseServiceImpl;
import com.neo.gyl.basedata.dao.ProductDao;
import com.neo.gyl.basedata.service.ProductService;
import com.neo.gyl.domain.basedata.Product;

@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService{

	@Resource(name="productDao")
	private ProductDao productDao;
	
	@Override
	public BaseDao<Product> getBaseDao() {
		return this.productDao;
	}

}
