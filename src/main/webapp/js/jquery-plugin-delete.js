(function($){
	$.delObjs = function(config){
		$("#" + config.delBtn).unbind("click");
		$("#" + config.delBtn).bind("click",function(){
			var checkedArray = $("input[name='"+config.itemsName+"']:checked");
			if(checkedArray.length == 0){
				alert("请选择要删除的项");
			} else {
				if(window.confirm("确定删除吗？")){
					var checkedStr = "";
					for (var i = 0; i < checkedArray.length; i++) {
						if(i == checkedArray.length-1){
							checkedStr += $(checkedArray[i]).val();
						} else {
							checkedStr += $(checkedArray[i]).val() + ",";
						}
					}
					window.location.href = config.url + "?checkedStr=" + checkedStr;
				}
			}
		});
		
		$("#" + config.controlCheckbox).unbind("click");
		$("#" + config.controlCheckbox).bind("click",function(){
			$("input[name='"+config.itemsName+"']").attr("checked",$(this).attr("checked"));
		});
		
		$("input[name='"+config.itemsName+"']").unbind("click")
		$("input[name='"+config.itemsName+"']").bind("click",function(){
			$("#" + config.controlCheckbox).attr("checked",$("input[name='"+config.itemsName+"']:checked").length==$("input[name='"+config.itemsName+"']").length);
		});
	}
})(jQuery);