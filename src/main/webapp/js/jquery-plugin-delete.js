(function($){
	$.delObjs = function(config){
		$("#" + config.delBtn).unbind("click");
		$("#" + config.delBtn).bind("click",function(){
			alert("aaa");
		});
	}
})(jQuery);