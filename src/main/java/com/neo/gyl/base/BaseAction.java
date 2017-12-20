package com.neo.gyl.base;

import java.lang.reflect.ParameterizedType;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	private Class<T> clazz;
	private T instance;

	public BaseAction() {
		try {
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			this.clazz = (Class<T>) type.getActualTypeArguments()[0];
			this.instance = this.clazz.newInstance();
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public T getModel() {
		return this.instance;
	}
	
	/**
	 * 常量
	 */
	public static final String SAVEUI = "saveUI";
	public static final String UPDATEUI = "updateUI";
	public static final String ACTION2ACTION = "action2action";
	public static final String LISTACTION = "listAction";
	public static final String chain = "chain";

	/**
	 * 分页参数接收
	 */
	private Integer currentPage;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	/**
	 * 获取session
	 */
	public HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	
	/**
	 * 多行删除参数
	 */
	private String checkedStr;

	public String getCheckedStr() {
		return checkedStr;
	}

	public void setCheckedStr(String checkedStr) {
		this.checkedStr = checkedStr;
	}
}
