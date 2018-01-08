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

import com.neo.gyl.business.xsgl.service.XsyddService;
import com.neo.gyl.domain.business.xsgl.Xsyddzhib;
import com.neo.gyl.domain.business.xsgl.Xsyddzhub;
import com.neo.gyl.query.PageResult;
import com.neo.gyl.query.business.xsgl.XsyddzhibQuery;
import com.neo.gyl.query.business.xsgl.XsyddzhubQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("xsyddAction")
@Scope("prototype")
public class XsyddAction {

	// jsp页面使用<s:textfield name="query_zhub.ddh"/>提交数据
	private XsyddzhubQuery query_zhub = new XsyddzhubQuery();
	private XsyddzhibQuery query_zhib = new XsyddzhibQuery();

	public XsyddzhubQuery getQuery_zhub() {
		return query_zhub;
	}

	public void setQuery_zhub(XsyddzhubQuery query_zhub) {
		this.query_zhub = query_zhub;
	}

	public XsyddzhibQuery getQuery_zhib() {
		return query_zhib;
	}

	public void setQuery_zhib(XsyddzhibQuery query_zhib) {
		this.query_zhib = query_zhib;
	}

	@Resource(name = "xsyddService")
	private XsyddService xsyddService;

	//显示所有销售预订单
	public String showAllXsydd() throws Exception{
		PageResult<Xsyddzhub> pageResult_zhub = this.xsyddService.getPageResult_zhub(query_zhub);
		PageResult<Xsyddzhib> pageResult_zhib = this.xsyddService.getPageResult_zhib(query_zhib);
		ActionContext.getContext().put("pageResult_zhub", pageResult_zhub);
		ActionContext.getContext().put("pageResult_zhib", pageResult_zhib);
		return "listAction";
	}
	
	//增加
	public String saveUI() throws Exception {
		return "saveUI";
	}
	
	private List<Xsyddzhib> xsyddzhibs = new ArrayList<Xsyddzhib>();
	public List<Xsyddzhib> getXsyddzhibs() {
		return xsyddzhibs;
	}
	public void setXsyddzhibs(List<Xsyddzhib> xsyddzhibs) {
		this.xsyddzhibs = xsyddzhibs;
	}
	public String save() throws Exception {
		Xsyddzhub xsyddzhub = new Xsyddzhub();
		//普通属性
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		BeanUtils.copyProperties(xsyddzhub, this.query_zhub);
		//建立关联, 需要在Xsyddzhub.hbm.xml中设置cascade="all"
		xsyddzhub.setXsyddzhibs(new HashSet<Xsyddzhib>(this.xsyddzhibs));
		//设置订单号
		xsyddzhub.setDdh(this.xsyddService.getMaxDDH());
		//保存
		this.xsyddService.saveEntry_zhub(xsyddzhub);
		return "chain";
	}
	
	
}
