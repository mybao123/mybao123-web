/**
 * 移动端javascript代码
 */
(function() {
	"use strict";

	document.addEventListener('deviceready', onDeviceReady.bind(this), false);

	function onDeviceReady() {
	}

	function onOffline() {
		alert("offline!");
	}
	
})();

/**
 * #login Page   begin
 */
/**
 * 用户登录
 */
function onLogin() {
	$.mobile.changePage("#today", {
		transition : "slideup"
	});
}

/**
 * #login Page   end
 */

