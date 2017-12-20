var GylUtils = {
	/**
	 * 基础模块
	 */
	basedata:{
		disPage:{
			linkNextPage:function(){
				var currentPage = $(this).attr("param");
				var url = $("body").data("url");
				window.location.href = url + "?currentPage=" + currentPage;
			}
		},
		initEvent:function(){
			$("input[flag='firstPage']").unbind("click");
			$("input[flag='firstPage']").bind("click",function(){
				GylUtils.basedata.disPage.linkNextPage.call(this);
			});
			$("input[flag='prePage']").unbind("click");
			$("input[flag='prePage']").bind("click",function(){
				if($(this).attr("param") < 1){
					alert("已经是第一页了");
				} else {
					GylUtils.basedata.disPage.linkNextPage.call(this);
				}
			});
			$("input[flag='nextPage']").unbind("click");
			$("input[flag='nextPage']").bind("click",function(){
				if($(this).attr("param") > $("input[flag='lastPage']").attr("param")){
					alert("已经是最后一页了");
				} else {
					GylUtils.basedata.disPage.linkNextPage.call(this);
				}
			});
			$("input[flag='lastPage']").unbind("click");
			$("input[flag='lastPage']").bind("click",function(){
				GylUtils.basedata.disPage.linkNextPage.call(this);
			});
			$("input[value='跳转']").unbind("click");
			$("input[value='跳转']").bind("click",function(){
				var pageNo = $("#pageNo").val();
				if(parseInt(pageNo)!=pageNo  || pageNo<1 || pageNo>$("input[flag='lastPage']").attr("param")){
					alert("无效的页码");
				} else {
					$(this).attr("param",pageNo);
					GylUtils.basedata.disPage.linkNextPage.call(this);
				}
				$("#pageNo").val("");
			});
		}
	},
	/**
	 * 权限模块
	 */
	privilege:{
		
	},
	/**
	 * 业务模块
	 */
	business:{
		
	}
};