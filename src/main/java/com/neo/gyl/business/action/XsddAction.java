package com.neo.gyl.business.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neo.gyl.business.xsgl.service.XsddService;
import com.neo.gyl.domain.business.xsgl.Xsddzhib;
import com.neo.gyl.domain.business.xsgl.Xsddzhub;
import com.neo.gyl.query.PageResult;
import com.neo.gyl.query.business.xsgl.XsddzhibQuery;
import com.neo.gyl.query.business.xsgl.XsddzhubQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("xsddAction")
@Scope("prototype")
public class XsddAction {
	private XsddzhubQuery query_zhub = new XsddzhubQuery();
	private XsddzhibQuery query_zhib = new XsddzhibQuery();
	private List<Xsddzhib> xsddzhibs = new ArrayList<Xsddzhib>();

	@Resource(name="xsddService")
	private XsddService xsddService;

	// 显示所有销售预订单
	public String showAllXsdd() throws Exception {
		PageResult<Xsddzhub> pageResult_zhub = this.xsddService
				.getPageResult_zhub(query_zhub);
		PageResult<Xsddzhib> pageResult_zhib = this.xsddService
				.getPageResult_zhib(query_zhib);
		ActionContext.getContext().put("pageResult_zhub", pageResult_zhub);
		ActionContext.getContext().put("pageResult_zhib", pageResult_zhib);
		return "listAction";
	}

	// 增加UI
	public String saveUI() throws Exception {
		return "saveUI";
	}
	
	// 增加
	public String save() throws Exception {
		Xsddzhub xsddzhub = new Xsddzhub();
		//普通属性 + 日期属性
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		BeanUtils.copyProperties(xsddzhub, this.query_zhub);
		//关联的子表
		xsddzhub.setXsddzhibs(new HashSet<Xsddzhib>(this.xsddzhibs));
		//设置订单号
		xsddzhub.setDdh(this.xsddService.getMaxDDH());
		//保存
		this.xsddService.saveEntry_zhub(xsddzhub);
		return "chain";
	}

	//getters setters
	public XsddzhubQuery getQuery_zhub() {
		return query_zhub;
	}

	public void setQuery_zhub(XsddzhubQuery query_zhub) {
		this.query_zhub = query_zhub;
	}

	public XsddzhibQuery getQuery_zhib() {
		return query_zhib;
	}

	public void setQuery_zhib(XsddzhibQuery query_zhib) {
		this.query_zhib = query_zhib;
	}

	public List<Xsddzhib> getXsddzhibs() {
		return xsddzhibs;
	}

	public void setXsddzhibs(List<Xsddzhib> xsddzhibs) {
		this.xsddzhibs = xsddzhibs;
	}
	
	
}
