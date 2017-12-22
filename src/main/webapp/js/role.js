var roletree = {
	data : {
		treeNode:'',
		zTreePlugin:''
	},
	setting : {
		isSimpleData : true,
		treeNodeKey : "rid",
		treeNodeParentKey : "pid",
		showLine : true,
		root : {
			isRoot : true,
			nodes : []
		},
		callback : {
			rightClick : function(event, treeId, treeNode) {
				roletree.data.treeNode = treeNode; // 数据
				roletree.showRMenu(event.clientX, event.clientY);
			}
		}

	},
	showRoleTree : function() {
		$.post("roleAction_showRoleTree.action", null, function(data) {
			roletree.data.zTreePlugin = $("#roleTree").zTree(roletree.setting,data); // 数据
		});
	},
	//显示右键菜单
	showRMenu:function(x,y){
		$("#rMenu ul").show();
		$("#rMenu").css({"top":y+"px", "left":x+"px", "display":"block"});
	},
	//隐藏右键菜单
	hideRMenu:function(){
		$("#rMenu").hide();
	},
	//添加角色
	addRole:function(){
		var roleName = window.prompt("添加的角色名：");
		var params = {
			pid:roletree.data.treeNode.rid,
			name:roleName,
			isParent:false
		}
		if(roletree.data.zTreePlugin.getNodeByParam("name",roleName)){
			alert("角色名已存在");	
		} else {
			$.post("roleAction_add.action",params,function(data){
				var newNodes = {
					rid:data.rid,
					pid:roletree.data.treeNode.rid,
					name:roleName,
					isParent:false	
				};
				roletree.data.zTreePlugin.addNodes(roletree.data.treeNode,newNodes,false);
			});
		}
	},
	//删除角色
	deleteRole:function(){
		$.post("roleAction_delete.action",{rid:roletree.data.treeNode.rid},function(data){
			roletree.data.zTreePlugin.removeNode(roletree.data.treeNode);
		});
	},
	//更新角色
	updateRole:function(){
		var newRoleName = window.prompt("修改角色名",roletree.data.treeNode.name);
		if(roletree.data.zTreePlugin.getNodeByParam("name",newRoleName)){
			alert("角色名已存在");	
		} else {
			var params = {
				rid:roletree.data.treeNode.rid,
				name:newRoleName
			};
			$.post("roleAction_update.action",params,function(data){
				roletree.data.treeNode.name = newRoleName;
				roletree.data.zTreePlugin.updateNode(roletree.data.treeNode,true);
				//roletree.data.zTreePlugin.refresh();
			});
		}
	},
	init:{
		initEvent:function(){
			$("#addRole").unbind("click");
			$("#addRole").bind("click",function(){
				roletree.addRole();
			});
			
			$("#deleteRole").unbind("click");
			$("#deleteRole").bind("click",function(){
				if(window.confirm("确定删除吗？")){
					roletree.deleteRole();
				}
			});
			
			$("#updateRole").unbind("click");
			$("#updateRole").bind("click",function(){
				roletree.updateRole();
			});
		}
	}
};

$().ready(function(){
	roletree.showRoleTree();
	$("#rMenu").hover(function(){
		
	},function(){
		roletree.hideRMenu();
	});
	roletree.init.initEvent();
});