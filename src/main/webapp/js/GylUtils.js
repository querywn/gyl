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
		data:{
			currentTr:'',
			cloneTr:''
		},
		divOpt:{
			showProductsDiv:function(){
				$("#seek").show();
			},
			hideProductsDiv:function(){
				$("#seek").hide();
			},
			fillCheckedValueToZhib:function(){
				var checkedTds = $(":radio:checked").parent().siblings("td");
				var $tr = GylUtils.business.data.currentTr;
				$.each(checkedTds,function(){  //迭代行
					var currCheckedTd = this;
					var itemName = $(this).attr("item");  //spmc
					$.each($tr,function(){  //迭代列
						if(itemName == "spmc"){
							$(this).children("td[item='"+itemName+"']").children("div").children("input").val($(currCheckedTd).text());
						} else {
							$(this).children("td[item='"+itemName+"']").children("input").val($(currCheckedTd).text());
						}
					});
				});
			}
		},
		add:{
			//点击搜索按钮显示【商品列表div】
			showProductsDivEvent:function(){
				$(".searRR").unbind("click");
				$(".searRR").bind("click",function(){
					//显示【商品列表div】
					GylUtils.business.divOpt.showProductsDiv();
					
					//加载初始化商品数据
					if($("#seek table tbody tr").length < 2){
						$.fn.GirdPanel.createTable({
							url:'productJSONAction_showProducts.action',
							fields:$("#seek *[item]")
						});
					}
					
					//记录当前操作的tr
					GylUtils.business.data.currentTr = $(this).parent().parent().parent();
				
				});
			},
			//点击【商品列表div】上的确定按钮回显div
			showProductsDivSureEvent:function(){
				$(".btn").unbind("click");
				$(".btn").bind("click",function(){
					GylUtils.business.divOpt.fillCheckedValueToZhib();
					GylUtils.business.divOpt.hideProductsDiv();  //添加值完毕后隐藏【商品列表div】
					
					//克隆当前操作的tr (必须在添加事件响应前)
					GylUtils.business.data.cloneTr = GylUtils.business.data.currentTr.clone(true);
					return false;
				});
			},
			//显示右键菜单
			showRMenu:function(x,y){
				$("#menu").css({"top":y-50+"px", "left":x-50+"px", "display":"block","background":"rgba(255,255,255, 0)"});
				$("#menu").css("height","40");
				$("#menu").css("width","60");
				$("#menu").show();
			},
			//隐藏右键菜单
			hideRMenu:function(){
				$("#menu").hover(function(){
				},function(){
					$(this).hide();
				});
			},
			//右键菜单事件
			menuEvent:function(){
				$("body").delegate("td[item='hh']","contextmenu",function(e){
					GylUtils.business.add.showRMenu(e.clientX, e.clientY);
					return false;
				});
			},
			//增加行事件
			addRowEvent:function(){
				$("#addRow").unbind("click")
				$("#addRow").bind("click",function(){
					GylUtils.business.add.addRow();
				})
			},
			//增加行
			addRow:function(){
				//上一行点击选择按钮时克隆tr
				var $tr = GylUtils.business.data.cloneTr;
				$("#right_center table tbody").append($tr);
				//移除前一个tr的seek的div
				GylUtils.business.data.currentTr.children("td").children("#seek").remove()
			},
			initEvent:function(){
				//【显示商品列表】
				GylUtils.business.add.showProductsDivEvent();
				//【显示商品列表】确定按钮事件
				GylUtils.business.add.showProductsDivSureEvent();
				//【右键菜单】事件
				GylUtils.business.add.menuEvent();
				//左键离开菜单时，隐藏【右键菜单】
				GylUtils.business.add.hideRMenu();
				//【增行】事件
				GylUtils.business.add.addRowEvent();
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