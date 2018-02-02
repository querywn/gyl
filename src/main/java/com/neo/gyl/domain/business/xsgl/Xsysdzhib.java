package com.neo.gyl.domain.business.xsgl;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/** 
 * 销售应收单子表
 */
public class Xsysdzhib implements Serializable{
	private Integer xsysdzhibid;//主键
	private Integer sl;//数量 
	private Integer hh;
	private String spmc;
	private String spbm;
	private String dw;
	private Float hsje;//含税金额
	private Float se;//税额
	private Float wsje;//无税金额
	private String lydjh;//来源单据号  发票号
	private String lyhh;//来源行号
	private String ytdjh;//源头单据号
	private Integer ythh;//源头行号
	private Float dj;//单价
	
	private Integer ljyssl = 0;//累计应收数量
	private Boolean isysgb = false;//是否应收关闭
	
	
	
	public Integer getLjyssl() {
		return ljyssl;
	}
	public void setLjyssl(Integer ljyssl) {
		this.ljyssl = ljyssl;
	}
	public Boolean getIsysgb() {
		return isysgb;
	}
	public void setIsysgb(Boolean isysgb) {
		this.isysgb = isysgb;
	}
	private Xsysdzhub xsysdzhub;
	
	public String getLyhh() {
		return lyhh;
	}
	public void setLyhh(String lyhh) {
		this.lyhh = lyhh;
	}
	public Integer getYthh() {
		return ythh;
	}
	public void setYthh(Integer ythh) {
		this.ythh = ythh;
	}
	public Integer getSl() {
		return sl;
	}
	public void setSl(Integer sl) {
		this.sl = sl;
	}
	public String getYtdjh() {
		return ytdjh;
	}
	public void setYtdjh(String ytdjh) {
		this.ytdjh = ytdjh;
	}
	public Xsysdzhub getXsysdzhub() {
		return xsysdzhub;
	}
	public void setXsysdzhub(Xsysdzhub xsysdzhub) {
		this.xsysdzhub = xsysdzhub;
	}
	public Integer getXsysdzhibid() {
		return xsysdzhibid;
	}
	public void setXsysdzhibid(Integer xsysdzhibid) {
		this.xsysdzhibid = xsysdzhibid;
	}
	public Integer getHh() {
		return hh;
	}
	public void setHh(Integer hh) {
		this.hh = hh;
	}
	
	
	public String getSpmc() {
		return spmc;
	}
	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}
	public String getSpbm() {
		return spbm;
	}
	public void setSpbm(String spbm) {
		this.spbm = spbm;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public Float getHsje() {
		return hsje;
	}
	public void setHsje(Float hsje) {
		this.hsje = hsje;
	}
	public Float getSe() {
		return se;
	}
	public void setSe(Float se) {
		this.se = se;
	}
	public Float getWsje() {
		return wsje;
	}
	public void setWsje(Float wsje) {
		this.wsje = wsje;
	}
	public String getLydjh() {
		return lydjh;
	}
	public void setLydjh(String lydjh) {
		this.lydjh = lydjh;
	}
	public Float getDj() {
		return dj;
	}
	public void setDj(Float dj) {
		this.dj = dj;
	}
}
