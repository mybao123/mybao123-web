/**
 * 
 */

$(function () {
	$('#txtSerialNo').val('1111'); 
});
function loadAction(){  
	var module ='88f6ae182d92151ed240e0c7f51136144609dd5ced49f28171ef33af1e3b1d64c7b5939bc0b12e22f3a046168f8890371555e933a2a5714f7b3a858946eea17f';
	var password=$('#txtpassWord').val();  
	var empoent= '10001';  
	alert(1);
	setMaxDigits(131); //131 => n的十六进制位数/2+3  
	  
	alert(1);
    var key  = new RSAKeyPair(empoent, '', module); //10001 => e的十六进制
    
    password = encryptedString(key, password);
     
    var username =$('#txtuserName').val();
    var user ={};
    user.name=username;
    user.psd = password;
     
	$.ajax({
       url: "User/userLogin.do",
        type: "POST",
        dataType: "json",
        async:false, 
        data:user,
        //contentType: "application/x-www-form-urlencoded; charset=utf-8", 
        success: function (req) {  
        	$('#txtuserName').val(Id) ; 
        	$('#txtpassWord').val(IsSuceed);
        	$('#txtpassWord1').val(Message);
        }
    });
} 
 
