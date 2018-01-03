(function($){
	$.fn.GirdPanel = {
		defaultConfig:{
			url:'',
			data:'',
			fields:'' //所有的列
		},
		createTable:function(config){
			$.extend($.fn.GirdPanel.defaultConfig,config);
			$.post($.fn.GirdPanel.defaultConfig.url,null,function(data){
				$.fn.GirdPanel.createTr(data);  //data == [{},{}]
			});
		},
		createTr:function(data){
			$.each(data,function(){
				var $tr = $("<tr/>");
				var row = this;  // {a:'',b:''};
				$.each($.fn.GirdPanel.defaultConfig.fields,function(){
					var field = this;
					var $td = $.fn.GirdPanel.createTd(row, field);
					$tr.append($td);
				});
				$("#seek table tbody").append($tr);
			});
		},
		//row  {"商品名称":"碧根果",b:''}
		//field  <input item="...">
		//$(field).attr("item") == "spmc"
		//row[$(field).attr("item")] == "碧根果"
		createTd:function(row, field){
			if($(field).attr("item") == "radio"){
				return $("<td/>").append($("<input/>").attr("type","radio").attr("name","iradio"));
			} else {
				return $("<td/>").attr("item",$(field).attr("item")).text(row[$(field).attr("item")]);
			}
		}
	};
})($);