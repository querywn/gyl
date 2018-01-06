package com.neo.gyl.basedata.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neo.gyl.base.BaseAction;
import com.neo.gyl.basedata.service.ProductService;
import com.neo.gyl.domain.basedata.Product;
import com.opensymphony.xwork2.ActionContext;

@Controller("productAction")
@Scope("prototype")
public class ProductAction extends BaseAction<Product>{
	
	@Resource(name="productService")
	private ProductService productService;
	
	
	public String showProducts() throws Exception {
		Collection<Product> products = (Collection<Product>) this.getSession().getAttribute("products");
		if(products==null || products.size()<1){
			products = this.productService.getAllEntries();
			this.getSession().setAttribute("products", products);
		}
		ActionContext.getContext().getValueStack().push(products);
		return SUCCESS;
	}
	
	public String saveUI() throws Exception {
		return SAVEUI;
	}
}
