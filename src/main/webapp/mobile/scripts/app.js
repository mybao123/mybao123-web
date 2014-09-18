/**
 * 
 */
$(function() {   
    	 var sContent = "";
		 window.alert=function(msg){  
			 navigator.notification.alert(msg);    
		 };
		 $("#today").on("swipeleft",function(){ 
			 window.location.href="#total";
		 });    
		 $("#today").on("swiperight",function(){ 
			 window.location.href="#yesterday";
		 }); 
		 $("#total").on("swipeleft",function(){ 
			 window.location.href="#total";
		 });    
		 $("#total").on("swiperight",function(){ 
			 window.location.href="#today";
		 });   
		 $("#yesterday").on("swiperight",function(){ 
			 window.location.href="#yesterday";
		 });    
		 $("#yesterday").on("swipeleft",function(){ 
			 window.location.href="#today";
		 });    
		 $("#calendar").on("swiperight",function(){ 
			 window.location.href="#lmonth";
		 });    
		 $("#calendar").on("swipeleft",function(){ 
			 window.location.href="#nmonth";
		 });  
		 $("#nmonth").on("swipeleft",function(){ 
			 window.location.href="#nmonth";
		 }); 
		 $("#nmonth").on("swiperight",function(){ 
			 window.location.href="#calendar";
		 });  
		 $("#lmonth").on("swipeleft",function(){ 
			 window.location.href="#calendar";
		 }); 
		 $("#lmonth").on("swiperight",function(){ 
			 window.location.href="#lmonth";
		 }); 
		 $("img[name='photocat']").on("swiperight",function(){ 
			 if($("img[name='photocat']").attr("src")=="css/images/1.jpg"){ 
				 $("img[name='photocat']").attr("src","css/images/2.jpg");
			 }else if($("img[name='photocat']").attr("src")=="css/images/3.jpg"){ 
				 $("img[name='photocat']").attr("src","css/images/1.jpg");
			 }
		 }); 
		 $("img[name='photocat']").on("swipeleft",function(){  
			 if($("img[name='photocat']").attr("src")=="css/images/1.jpg"){ 
				 $("img[name='photocat']").attr("src","css/images/3.jpg");
			 }else if($("img[name='photocat']").attr("src")=="css/images/2.jpg"){ 
				 $("img[name='photocat']").attr("src","css/images/1.jpg");
			 }
		 }); 
		 //$("#masterpage").on("swipeleft",function(){ 
		 //	 window.location.href="#statistic";
		 //});   
		 //$("#statistic").on("swipeleft",function(){ 
		 //	 window.location.href="#TWeek";
		 //});      
		 //$("#statistic").on("swiperight",function(){ 
		 //	 window.location.href="#masterpage";
		 //});  
		 //$("#TWeek").on("swipeleft",function(){ 
		 //	 window.location.href="#TMonth";
		 //});    
		 //$("#TWeek").on("swiperight",function(){ 
		 //	 window.location.href="#statistic";
		 //});    
		 //$("#TMonth").on("swiperight",function(){ 
		 //	 window.location.href="#TWeek";
		 //});  
		  
		 //$("#setting").on("swipeleft",function(){ 
		 //	 window.location.href="#tasklabel";
		 //});    
		 //$("#tasklabel").on("swiperight",function(){ 
		//	 window.location.href="#setting";
		 //});    
		 $("li[name='recorddetail']").bind("taphold",function(event){
			 	//event.stopPropagation();
			    window.location.href="#confirm-dialog";
			    //return false;
		 });   
		 $("li[name='recorddetail']").bind("tap",function(event){
			 	event.stopPropagation();
			    window.location.href="#newrecord";
		 });  
		 $("h3[name='daysdetail']").bind("tap",function(event){ 
			    window.location.href="#today";
		 });   
		 $("label[name='contentdetail']").bind("tap",function(event){ 
			    window.location.href="#newrecord";
		 }); 
		 $("div[name='deptdetail']").on("tap",function(){
			    window.location.href="#deptstatistic";
		 });
		 $("div[name='persondetail']").on("tap",function(){
			    window.location.href="#personstatistic";
		 });
		 //点击打电话图标，调用电话接口，直接拨打电话
		 $("img[name='takecall']").bind("tap",function(event){
			 	event.stopPropagation();
			 	window.location.href="Tel:13568865179";
		 });   
		 $("img[name='selaryPic']").on("tap",function(e) {
			    window.location.href="#confirm-dialogpic"; 
		 }); 
		 
		 $("#yNewRecord").bind("click",function(){ 
			 window.location.href="#newrecord"; 
		 });
		 //点击地址图标，获取实际地址
		 $("img[name='getlocationAddress']").on("tap",function(){ 
			 var gps = navigator.geolocation;
			 if (gps)
			 {	
			 	gps.getCurrentPosition(showgps,function(error){alert("Got an error, code: " + error.code + " message: "+ error.message);},{maximumAge: 10000}); // 这里设置超时为10000毫秒，即10秒
	         }
	     	 else
	     	 {
	         	showgps();
	     	 } 
			 $("#txtCustomerAddress").val(sContent);
		 });
		  
 		 //调用手机接口，获取经纬度
		 function showgps(position)
		 {
             if (position)
             {
                 var latitude = position.coords.latitude;
                 var longitude = position.coords.longitude;
                 getLocationAddress(longitude,latitude);
                 //alert("latitude: " + latitude + "\r\n longitude: "+ longitude);
             }
             else
                 alert("获取地理位置失败");
	     };
	     //调用百度地图API，解析经纬度，获取实际地址
	     function getLocationAddress(Longitude,Latitude) {
	         var loactionPoint = new BMap.Point(Longitude, Latitude);    // 创建点坐标
	         var gc = new BMap.Geocoder();
	         gc.getLocation(loactionPoint, function (rs) {
	             var addComp = rs.addressComponents;
	             sContent += addComp.province + " " + addComp.city + " " + addComp.district + " " + addComp.street + " " + addComp.streetNumber;
		     }); 
	     }
		 function saveTaskInfo(){
			 
		 };  
		
		 $("a[name='getlocationphoto']").on("tap",function(){  
			 window.location.href="#photopage";
			 window.location.reload();
		 });  
		 window.addEventListener("DOMContentLoaded", function() { 

				$("#snap").show(); 
				$("#canvas").hide();
				$("#video").show();
				var imgData ;
				var data ;
				var length ;
				// canvas 元素将用于抓拍       
				var canvas = document.getElementById("canvas"),            
				context = canvas.getContext("2d"),            
				// video 元素，将用于接收并播放摄像头 的数据流            
				video = document.getElementById("video"),            
				videoObj = { "video": true },            
				// 一个出错的回调函数，在控制台打印出错信息          
				errBack = function(error) {                
					if("object" === typeof window.console){                    
						console.log("Video capture error: ", error.code);                 
						}            
					};         
					// Put video listeners into place        
					// 针对标准的浏览器        
					if(navigator.getUserMedia) { // Standard            
						navigator.getUserMedia(videoObj, function(stream) {                
							video.src = stream;                
							video.play();            
							}, errBack);       
					} else if(navigator.webkitGetUserMedia) { // WebKit-prefixed            
						navigator.webkitGetUserMedia(videoObj, function(stream){                
							video.src = window.webkitURL.createObjectURL(stream);                
							video.play();            
							}, errBack);        
					}        
					// 对拍照按钮的事件监听        
					document.getElementById("snap").addEventListener("click", function() {            // 画到画布上       
						//context.drawImage(video, 0, 0, 320,240, 0,0, 320,240);
					 	context.drawImage(video, 0, 0, 320, 150);  
					 	imgData =canvas.toDataURL("image/png");  
					 	data = imgData.substr(22);  
					 	length = atob(data).length;// atob decodes a string of data which has been encoded using base-64 encoding  
						showImage();
					});      
					// 对拍照按钮的事件监听        
					document.getElementById("snapsubmit").addEventListener("click", function() {  
						showvedio(length);
					});     
			}, false);
	});  
	function showImage(){
		$("#canvas").show();
		$("#video").hide();
		$("#snap").hide();  
	}
	function showvedio(imgData){ 
		//$("#txtCustomerphoto").val(imgData); //txtCustomerphoto
		window.location.href="#newrecord";
	} 
	function loginAction(){  
		var module ='88f6ae182d92151ed240e0c7f51136144609dd5ced49f28171ef33af1e3b1d64c7b5939bc0b12e22f3a046168f8890371555e933a2a5714f7b3a858946eea17f';
		var empoent= '10001';  
		var username = $("#txtusername").val();
		if (username == "") {
			alert("请输入用户名！");
			return;
		}
		var password = $("#txtpassword").val();
		if (password == "") {
			alert("请输入登录密码！");
			return;
		}
		setMaxDigits(131); //131 => n的十六进制位数/2+3  
		var key  = new RSAKeyPair(empoent, '', module); //10001 => e的十六进制  
    	var newpassword = encryptedString(key, password);
		 
		var User = {};
		User.name = username;
		User.psd = newpassword;
		$.ajax({
			url : "../Login/userLogin.do",
			type : "POST",
			dataType : "json",
			async : false,
			data : User,
			// contentType: "application/x-www-form-urlencoded; charset=utf-8",
			success : function(req) { 
				if(req){
					if(req.isSuceed){
						window.location.href="#masterpage";
					}else{
						alert(req.message);
					}
				}else{
					alert("登录失败");
				}
			}
		});
	} 