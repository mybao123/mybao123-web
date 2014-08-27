/**
 * 
 */

$(function () {
	 $("#txtTaskType").combobox({
		 url: 'TaskType/getTaskType.do',
		 valueField: 'id',
		 textField: 'text'
	 });
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
       url: "Login/userLogin.do",
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

function addTask(){	
	var task={};
	if($("#txtCustomerName").val()=="")
	{
		$.messager.alert("提示信息","请输入客户名称","warning");
		return;
	}
	task.PersonName=$("#txtCustomerName").val();
	if($("#txtCustomerphone").val()=="")
	{
		$.messager.alert("提示信息","请输入客户联系方式","warning");
		return;
	}
	task.PhoneNo=$("#txtCustomerphone").val();
	if($("#txtTaskType").combobox("getValue")||$("#txtTaskType").combobox("getText")=="")
	{
		$.messager.alert("提示信息","请输入记录类别","warning");
		return;
	}
	var TaskType ={};
	TaskType.id = $("#txtTaskType").combobox("getValue");
	TaskType.name = $("#txtTaskType").combobox("getText");
	task.TaskType = TaskType;
	if($("#txtTaskDescription").val()=="")
	{
		$.messager.alert("提示信息","请输入记录内容","warning");
		return;
	}
	task.Description=$("#txtTaskDescription").val(); 
	if($("#txtCustomerAddress").val()=="")
	{
		$.messager.alert("提示信息","请输入记录地址","warning");
		return;
	}
	task.Address=$("#txtCustomerAddress").val();
	if($("#txtCustomerAddress").datebox("getValue")=="")
	{
		$.messager.alert("提示信息","请输入记录时间","warning");
		return;
	}
	task.TaskTime=$("#txtCustomerAddress").datebox("getValue");
	
	$.ajax({
	       url: "Task/saveTask.do",
	        type: "POST",
	        dataType: "json",
	        async:false, 
	        data:task,
	        //contentType: "application/x-www-form-urlencoded; charset=utf-8", 
	        success: function (req) {  
	        	$('#txtuserName').val(Id) ; 
	        	$('#txtpassWord').val(IsSuceed);
	        	$('#txtpassWord1').val(Message);
	        }
	    });
}
