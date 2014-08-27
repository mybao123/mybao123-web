// For an introduction to the Blank template, see the following documentation:
// http://go.microsoft.com/fwlink/?LinkID=397704
// To debug code on page load in Ripple or on Android devices/emulators: launch your app, set breakpoints, 
// and then run "window.location.reload()" in the JavaScript Console.
(function() {
	"use strict";

	document.addEventListener('deviceready', onDeviceReady.bind(this), false);

	function onDeviceReady() {
		// Handle the Cordova pause and resume events
		document.addEventListener('pause', onPause.bind(this), false);
		document.addEventListener('resume', onResume.bind(this), false);
		document.addEventListener("offline", onOffline, false);
		document.addEventListener("online", onOnline, false);
		// TODO: Cordova has been loaded. Perform any initialization that
		// requires Cordova here.
	}
	;

	function onOnline() {
		alert("online!");
	}

	function onOffline() {
		alert("offline!");
	}

	function onPause() {
		// TODO: This application has been suspended. Save application state
		// here.
	}
	;

	function onResume() {
		// TODO: This application has been reactivated. Restore application
		// state here.
	}
	;

	function onSave() {

	}

})();

function onGetPosition() {

	var gps = navigator.geolocation;

	if (gps) {
		gps.getCurrentPosition(showgps, showerror, {
			maximumAge : 10000
		}); // 这里设置超时为10000毫秒，即10秒
	} else {
		showgps();
	}
}

function showgps(position) {
	if (position) {
		var latitude = position.coords.latitude;
		var longitude = position.coords.longitude;
		alert("latitude: " + latitude + "\r\n longitude: " + longitude);
	} else {
		alert("position is null");
	}
}

function showerror(error) {
	alert("Got an error, code: " + error.code + " message: " + error.message);
}