package com.neo.gyl.domain.business.xsgl;

import java.io.Serializable;
import java.util.Date;

/**
 * 销售出库单子表
 *
 */
public class Xsfhdzhib implements Serializable{
	private Integer xsfhdzhibid;//主键
	private Integer hh;//行号
	private String spbm;//商品编码
	private String spmc;//商品名称
	private String xh;//型号
	private String dw;//单位
	private Date scrq;//生产日期
	private Date sxrq;//失效日期
	private Integer yfsl;//应发数量
	private Integer sfsl;//实发数量
	private Float dj;//单价
	private Float je;//金额
	private Date fhrq;//发货日期
	private String zp;//赠品
	private String ytdjh;//源头单据号  销售订单号
	private String lydjh;//来源单据号  销售订单号
	private Integer lyhh;//来源行号           销售订单的子表的行号
	private Integer ythh;//源头行号           销售订单的子表的行号
	private Integer ljfhsl;//累计发货数量  是给发货人查看的,发货人是看不到销售订单的
	private Boolean isfhgb = false;//是否发货关闭    如果发货的数量和销售订单中子表的相应的行的数量一致，说明发货完毕，设置发货关闭为true
	
	private Xsfhdzhub xsfhdzhub;
	
	public String getSpbm() {
		return spbm;
	}

	public void setSpbm(String spbm) {
		this.spbm = spbm;
	}

	public String getSpmc() {
		return spmc;
	}

	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}

	public Integer getLjfhsl() {
		return ljfhsl;
	}

	public void setLjfhsl(Integer ljfhsl) {
		this.ljfhsl = ljfhsl;
	}

	public Date getFhrq() {
		return fhrq;
	}

	public void setFhrq(Date fhrq) {
		this.fhrq = fhrq;
	}

	public String getLydjh() {
		return lydjh;
	}

	public void setLydjh(String lydjh) {
		this.lydjh = lydjh;
	}

	public Integer getLyhh() {
		return lyhh;
	}

	public void setLyhh(Integer lyhh) {
		this.lyhh = lyhh;
	}

	public Xsfhdzhub getXsfhdzhub() {
		return xsfhdzhub;
	}

	public void setXsfhdzhub(Xsfhdzhub xsfhdzhub) {
		this.xsfhdzhub = xsfhdzhub;
	}

	public Integer getXsfhdzhibid() {
		return xsfhdzhibid;
	}

	public void setXsfhdzhibid(Integer xsfhdzhibid) {
		this.xsfhdzhibid = xsfhdzhibid;
	}

	public Integer getHh() {
		return hh;
	}

	public void setHh(Integer hh) {
		this.hh = hh;
	}


	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}


	public Date getScrq() {
		return scrq;
	}

	public void setScrq(Date scrq) {
		this.scrq = scrq;
	}

	public Date getSxrq() {
		return sxrq;
	}

	public void setSxrq(Date sxrq) {
		this.sxrq = sxrq;
	}

	public Integer getYfsl() {
		return yfsl;
	}

	public void setYfsl(Integer yfsl) {
		this.yfsl = yfsl;
	}

	public Integer getSfsl() {
		return sfsl;
	}

	public void setSfsl(Integer sfsl) {
		this.sfsl = sfsl;
	}

	public Float getDj() {
		return dj;
	}

	public void setDj(Float dj) {
		this.dj = dj;
	}

	public Float getJe() {
		return je;
	}

	public void setJe(Float je) {
		this.je = je;
	}

	

	public String getZp() {
		return zp;
	}

	public void setZp(String zp) {
		this.zp = zp;
	}

	public String getYtdjh() {
		return ytdjh;
	}

	public void setYtdjh(String ytdjh) {
		this.ytdjh = ytdjh;
	}

	public Integer getYthh() {
		return ythh;
	}

	public void setYthh(Integer ythh) {
		this.ythh = ythh;
	}


	public Boolean getIsfhgb() {
		return isfhgb;
	}

	public void setIsfhgb(Boolean isfhgb) {
		this.isfhgb = isfhgb;
	}
}
