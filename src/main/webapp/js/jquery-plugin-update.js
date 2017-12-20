(function($){
	$.updateObj = function(config){
		window.location.href = config.url + "?" + config.idName + "=" + config.idValue;
	}
})(jQuery);