var role_privilege = {
	data:{
		role:{
			rid:'',
			name:''
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
		roleOpt:{
			showRoleName:function(){
				$("#roleImage").text(role_privilege.data.role.name);
			}
		},
		privilegeTree:{
			setting : {
				isSimpleData : true,
				treeNodeKey : "id",
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
						$("#allchecked").attr("checked",role_privilege.data.zTreePlugin.getCheckedNodes(false)==0);
					}
				}
			},
			showPrivilegeTree : function() {
				$.post("privilegeAction_showPrivilegeTree.action", {rid:role_privilege.data.role.rid},function(data) {
					role_privilege.data.zTreePlugin = $("#privilegeTree").zTree(role_privilege.opt.privilegeTree.setting,data);
					//显示loading图片。隐藏树
					$("#loading").hide();
					$("#privilegeTree").show();
					//全选按钮可用
					$("#allchecked").attr("disable","");
					//全选按钮状态设置
					$("#allchecked").attr("checked",role_privilege.data.zTreePlugin.getCheckedNodes(false).length==0);
				});
			},
			updateRolePrivileges:function(){
				var checkedStr = "";
				var checkedNodes = role_privilege.data.zTreePlugin.getCheckedNodes(true);
				for (var i = 0; i < checkedNodes.length; i++) {
					if(i == checkedNodes.length-1){
						checkedStr += checkedNodes[i].id;
					} else {
						checkedStr += checkedNodes[i].id + ","; 
					}
				}
				var parsms = {
					rid:role_privilege.data.role.rid,
					checkedStr:checkedStr
				};
				$.post("privilegeAction_updateRolePrivileges.action",parsms,function(){
					alert("更新成功");
				});
			}
		}
	},
	init:{
		initData:function(){
			role_privilege.data.role.rid = $(this).parent().siblings("input:eq(0)").val();
			role_privilege.data.role.name = $(this).parent().siblings("td:eq(0)").text();
		},
		initEvent:function(){
			$("a").unbind("click");
			$("a").bind("click",function(){
				if($(this).text() == "设置权限"){
					//显示div
					role_privilege.opt.divOpt.showDiv();
					//初始化数据
					role_privilege.init.initData.call(this);
					//显示角色名
					role_privilege.opt.roleOpt.showRoleName();
					//显示loading图片。隐藏树
					$("#loading").show();
					$("#privilegeTree").hide();
					//全选按钮不可用
					$("#allchecked").attr("disable","disable");
					//加载权限树
					role_privilege.opt.privilegeTree.showPrivilegeTree();
				}
			});
			
			//全选按钮与树的联动
			$("#allchecked").unbind("click");
			$("#allchecked").bind("click",function(){
				role_privilege.data.zTreePlugin.checkAllNodes($(this).attr("checked"));
			});
			
			//更新权限
			$("#savePrivilege").unbind("click");
			$("#savePrivilege").bind("click",function(){
				role_privilege.opt.privilegeTree.updateRolePrivileges();
			});
		}
	}
};

$().ready(function(){
	role_privilege.init.initEvent();
});