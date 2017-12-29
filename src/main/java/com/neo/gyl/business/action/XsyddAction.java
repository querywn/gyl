package com.neo.gyl.business.action;

import javax.annotation.Resource;

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

	public String showAllXsydd() throws Exception{
		PageResult<Xsyddzhub> pageResult_zhub = this.xsyddService.getPageResult_zhub(query_zhub);
		PageResult<Xsyddzhib> pageResult_zhib = this.xsyddService.getPageResult_zhib(query_zhib);
		ActionContext.getContext().put("pageResult_zhub", pageResult_zhub);
		ActionContext.getContext().put("pageResult_zhib", pageResult_zhib);
		return "listAction";
	}
}
