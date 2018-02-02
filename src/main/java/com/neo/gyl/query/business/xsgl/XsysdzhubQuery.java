package com.neo.gyl.query.business.xsgl;

import java.util.Date;
import java.util.Map;

import com.neo.gyl.query.BaseQuery;


public class XsysdzhubQuery extends BaseQuery {
	private Integer ddh;
	private String gs;
	private Date rq;//日期
	private Date qsrq;//起算日期
	private String ks;//客商
	private String bm;//部门
	private String ywy;//业务员
	private String sxbz;//生效标志
	private String zdr;//制单人
	private Date zdrq;//制单日期
	private String shr;//审核人
	private Date shrq;//审核日期
	private String qzr;//签字人
	private Date qzrq;//签字日期
	private String xgr;//修改人
	private Date xgrq;//修改日期

	
	@Override
	public Map<String, Object> buildConditionMap() {
		if(this.ddh != null){
			this.getConditionMap().put("ddh", ddh);
		}
		if(this.gs != null){
			this.getConditionMap().put("gs", gs);
		}
		if(this.rq!=null){
			this.getConditionMap().put("rq",rq);
		}
		if(this.qsrq!=null){
			this.getConditionMap().put("qsrq",qsrq);
		}
		
		if(this.ks!=null){
			this.getConditionMap().put("ks",ks);
		}
		if(this.bm!=null){
			this.getConditionMap().put("bm",bm);
		}
		if(this.ywy!=null){
			this.getConditionMap().put("ywy",ywy);
		}
		if(this.sxbz!=null){
			this.getConditionMap().put("sxbz",sxbz);
		}
		
		if(this.zdr!=null){
			this.getConditionMap().put("zdr",zdr);
		}
		if(this.zdrq!=null){
			this.getConditionMap().put("zdrq",zdrq);
		}
		if(this.shr!=null){
			this.getConditionMap().put("shr",shr);
		}
		if(this.shrq!=null){
			this.getConditionMap().put("shrq",shrq);
		}
		if(this.qzr!=null){
			this.getConditionMap().put("qzr",qzr);
		}
		if(this.qzrq!=null){
			this.getConditionMap().put("qzrq",qzrq);
		}
		if(this.xgr!=null){
			this.getConditionMap().put("xgr",xgr);
		}
		if(this.xgrq!=null){
			this.getConditionMap().put("xgrq",xgrq);
		}
		return this.getConditionMap();
	}
}
