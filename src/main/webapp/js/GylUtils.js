var GylUtils = {
	/**
	 * 基础模块
	 */
	basedata:{
		delObjs:{
			delFunction:function(config){
				$.delObjs(config);
			}
		},
		updateObj:{
			updateFunction:function(config){
				$.updateObj(config);
			}
		},
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
		//
		divOpt:{
			showProductsDiv:function(){
				$("#seek").show();
			}
		},
		add:{
			showProductsDivEvent:function(){
				$(".searRR").unbind("click");
				$(".searRR").bind("click",function(){
					GylUtils.business.divOpt.showProductsDiv();
					$.fn.GirdPanel.createTable({
						url:'productJSONAction_showProducts.action',
						fields:$("#seek *[item]")
					});
				});
			}
		},
		//根据主表id显示子表
		showZhibList:function(){
			var xsyddzhubid = $(this).attr("id");
			var url = $("body").data("url");
			$("input[name='query_zhib.xsyddzhubid']").attr("value",xsyddzhubid);//子表分页
			var currentPage = $("#pageNo").val(); //传递主表页码
			window.location.href = url + xsyddzhubid + "&query_zhub.currentPage=" + currentPage;
		},
		//点击主表事件
		zhubTrClick:function(){
			$("tr[field='item_zhub']").unbind("click");
			$("tr[field='item_zhub']").bind("click",function(){
				GylUtils.business.showZhibList.call(this);
			});
		},
		//分页
		disPage:{
			//主表分页事件
			zhub:function(){
				$("input[flag='zhub_firstPage']").unbind("click");
				$("input[flag='zhub_firstPage']").bind("click",function(){
					GylUtils.business.disPage.linkNextPage_zhub.call(this);
				});
				$("input[flag='zhub_prePage']").unbind("click");
				$("input[flag='zhub_prePage']").bind("click",function(){
					if($(this).attr("param") < 1){
						alert("已经是第一页了");
					} else {
						GylUtils.business.disPage.linkNextPage_zhub.call(this);
					}
				});
				$("input[flag='zhub_nextPage']").unbind("click");
				$("input[flag='zhub_nextPage']").bind("click",function(){
					if($(this).attr("param") > $("input[flag='zhub_lastPage']").attr("param")){
						alert("已经是最后一页了");
					} else {
						GylUtils.business.disPage.linkNextPage_zhub.call(this);
					}
				});
				$("input[flag='zhub_lastPage']").unbind("click");
				$("input[flag='zhub_lastPage']").bind("click",function(){
					GylUtils.business.disPage.linkNextPage_zhub.call(this);
				});
			},
			//子表分页事件
			zhib:function(){
				$("input[flag='zhib_firstPage']").unbind("click");
				$("input[flag='zhib_firstPage']").bind("click",function(){
					GylUtils.business.disPage.linkNextPage_zhib.call(this);
				});
				$("input[flag='zhib_prePage']").unbind("click");
				$("input[flag='zhib_prePage']").bind("click",function(){
					if($(this).attr("param") < 1){
						alert("已经是第一页了");
					} else {
						GylUtils.business.disPage.linkNextPage_zhib.call(this);
					}
				});
				$("input[flag='zhib_nextPage']").unbind("click");
				$("input[flag='zhib_nextPage']").bind("click",function(){
					if($(this).attr("param") > $("input[flag='zhib_lastPage']").attr("param")){
						alert("已经是最后一页了");
					} else {
						GylUtils.business.disPage.linkNextPage_zhib.call(this);
					}
				});
				$("input[flag='zhib_lastPage']").unbind("click");
				$("input[flag='zhib_lastPage']").bind("click",function(){
					GylUtils.business.disPage.linkNextPage_zhib.call(this);
				});
			},
			linkNextPage_zhub:function(){
				var currentPage = $(this).attr("param");
				$("#pageNo").val(currentPage);
				document.forms[0].submit();
			},
			linkNextPage_zhib:function(){
				var currentPage = $(this).attr("param");
				$("#pageNo_zhib").val(currentPage);
				document.forms[0].submit();
			}
		},
		init:{
			data:{
				currentTr:''
			},
			initEvent:function(){
				GylUtils.business.zhubTrClick();
				GylUtils.business.disPage.zhub();
				GylUtils.business.disPage.zhib();
			}
		}
	}
};