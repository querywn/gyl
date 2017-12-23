var user_role = {
	data:{
		user:{
			uid:'',
			username:''
		},
		checkedStr:'',
		zTreePlugin:''
	},
	opt:{
		divOpt:{
			showDiv:function(){
				$("div:hidden").show();
			}
		},
		userOpt:{
			showUserName:function(){
				$("#userImage").text(user_role.data.user.username);
			}
		},
		roleTree:{
			setting : {
				isSimpleData : true,
				treeNodeKey : "rid",
				treeNodeParentKey : "pid",
				showLine : true,
				checkable : true,
				root : {
					isRoot : true,
					nodes : []
				},
				callback:{
					change:function(){
						//树与全选按钮的联动
						$("#allchecked").attr("checked",user_role.data.zTreePlugin.getCheckedNodes(false)==0);
					}
				}
			},
			showRoleTree : function() {
				$.post("roleAction_showRoleTree.action", {uid:user_role.data.user.uid},function(data) {
					user_role.data.zTreePlugin = $("#roleTree").zTree(user_role.opt.roleTree.setting,data);
					//显示loading图片。隐藏树
					$("#loading").hide();
					$("#roleTree").show();
					//全选按钮可用
					$("#allchecked").attr("disable","");
					//全选按钮状态设置
					$("#allchecked").attr("checked",user_role.data.zTreePlugin.getCheckedNodes(false).length==0);
				});
			},
			updateUserRoles:function(){
				var checkedStr = "";
				var checkedNodes = user_role.data.zTreePlugin.getCheckedNodes(true);
				for (var i = 0; i < checkedNodes.length; i++) {
					if(i == checkedNodes.length-1){
						checkedStr += checkedNodes[i].rid;
					} else {
						checkedStr += checkedNodes[i].rid + ","; 
					}
				}
				var parsms = {
					uid:user_role.data.user.uid,
					checkedStr:checkedStr
				};
				$.post("roleAction_updateUserRoles.action",parsms,function(){
					alert("更新成功");
				});
			}
		}
	},
	init:{
		initData:function(){
			user_role.data.user.uid = $(this).parent().siblings("input:eq(0)").val();
			user_role.data.user.username = $(this).parent().siblings("td:eq(0)").text();
		},
		initEvent:function(){
			$("a").unbind("click");
			$("a").bind("click",function(){
				if($(this).text() == "设置角色"){
					//显示div
					user_role.opt.divOpt.showDiv();
					//初始化数据
					user_role.init.initData.call(this);
					//显示用户名
					user_role.opt.userOpt.showUserName();
					//显示loading图片。隐藏树
					$("#loading").show();
					$("#roleTree").hide();
					//全选按钮不可用
					$("#allchecked").attr("disable","disable");
					//加载角色树
					user_role.opt.roleTree.showRoleTree();
				}
			});
			
			//全选按钮与树的联动
			$("#allchecked").unbind("click");
			$("#allchecked").bind("click",function(){
				user_role.data.zTreePlugin.checkAllNodes($(this).attr("checked"));
			});
			
			//更新角色
			$("#saveRole").unbind("click");
			$("#saveRole").bind("click",function(){
				user_role.opt.roleTree.updateUserRoles();
			});
		}
	}
};

$().ready(function(){
	user_role.init.initEvent();
});