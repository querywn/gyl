var privilege = {
	setting : {
		isSimpleData : true,
		treeNodeKey : "id",
		treeNodeParentKey : "pid",
		showLine : true,
		root : {
			isRoot : true,
			nodes : []
		}
	},
	shoMenuitemTree : function() {
		$.post("privilegeAction_showMenuitemTreeByUid.action", null,function(data) {
			$("#menuitemTree").zTree(privilege.setting, data);
		});
	}
};

$().ready(function(){
	privilege.shoMenuitemTree();
});