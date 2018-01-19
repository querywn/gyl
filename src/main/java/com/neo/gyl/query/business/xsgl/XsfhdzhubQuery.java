package com.neo.gyl.query.business.xsgl;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.neo.gyl.query.BaseQuery;

public class XsfhdzhubQuery extends BaseQuery {
	private Long xsfhdzhubid;// 主键
	private String ddh;// 单据号
	private String gs;// 公司
	private Date djrq;// 单据日期
	private String ck;// 仓库
	private String kgy;// 库管员
	private String bm;// 部门
	private String kh;// 客户
	private Boolean isth;// 是否退货
	private String status;// 单据状态
	private String zdr;// 制单人
	private Date zdrq;// 制单日期
	private String shr;// 审核人
	private Date shrq;// 审核日期
	private String qzr;// 签字人
	private Date xgrq;// 修改日期

	@Override
	public Map<String, Object> buildConditionMap() {
		if (StringUtils.isNotBlank(ddh)) {
			this.getConditionMap().put("ddh", ddh);
		}
		if (this.bm != null) {// 部门
			this.getConditionMap().put("bm", bm);
		}
		if (this.ck != null) {// 仓库
			this.getConditionMap().put("ck", ck);
		}
		if (StringUtils.isNotBlank(this.gs)) {
			this.getConditionMap().put("gs", gs);
		}
		if (this.djrq != null) {// 单据日期
			this.getConditionMap().put("djrq", djrq);
		}
		if (StringUtils.isNotBlank(this.ck)) {
			this.getConditionMap().put("ck", ck);
		}
		if (StringUtils.isNotBlank(kgy)) {
			this.getConditionMap().put("kgy", kgy);
		}
		if (StringUtils.isNotBlank(kh)) {
			this.getConditionMap().put("kh", kh);
		}

		if (StringUtils.isNotBlank(status)) {
			this.getConditionMap().put("status", status);
		}
		if (StringUtils.isNotBlank(zdr)) {
			this.getConditionMap().put("zdr", zdr);
		}
		if (zdrq != null) {
			this.getConditionMap().put("zdrq", zdrq);
		}
		if (StringUtils.isNotBlank(shr)) {
			this.getConditionMap().put("shr", shr);
		}
		if (xgrq != null) {
			this.getConditionMap().put("xgrq", xgrq);
		}
		if (shrq != null) {// 销售订单状态
			this.getConditionMap().put("shrq", shrq);
		}
		return this.getConditionMap();
	}

	public Long getXsfhdzhubid() {
		return xsfhdzhubid;
	}

	public void setXsfhdzhubid(Long xsfhdzhubid) {
		this.xsfhdzhubid = xsfhdzhubid;
	}

	public String getDdh() {
		return ddh;
	}

	public void setDdh(String ddh) {
		this.ddh = ddh;
	}

	public String getGs() {
		return gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
	}

	public Date getDjrq() {
		return djrq;
	}

	public void setDjrq(Date djrq) {
		this.djrq = djrq;
	}

	public String getCk() {
		return ck;
	}

	public void setCk(String ck) {
		this.ck = ck;
	}

	public String getKgy() {
		return kgy;
	}

	public void setKgy(String kgy) {
		this.kgy = kgy;
	}

	public String getBm() {
		return bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}

	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}

	public Boolean getIsth() {
		return isth;
	}

	public void setIsth(Boolean isth) {
		this.isth = isth;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getZdr() {
		return zdr;
	}

	public void setZdr(String zdr) {
		this.zdr = zdr;
	}

	public Date getZdrq() {
		return zdrq;
	}

	public void setZdrq(Date zdrq) {
		this.zdrq = zdrq;
	}

	public String getShr() {
		return shr;
	}

	public void setShr(String shr) {
		this.shr = shr;
	}

	public Date getShrq() {
		return shrq;
	}

	public void setShrq(Date shrq) {
		this.shrq = shrq;
	}

	public String getQzr() {
		return qzr;
	}

	public void setQzr(String qzr) {
		this.qzr = qzr;
	}

	public Date getXgrq() {
		return xgrq;
	}

	public void setXgrq(Date xgrq) {
		this.xgrq = xgrq;
	}

}
