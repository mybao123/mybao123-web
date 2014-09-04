function addTaskAction(){ 
	var customName = $("#txtCustomerName").val();
	if(customName==""){
		alert("客户名称不能为空");
		return;
	}
	var customPhone = $("#txtCustomerphone").val();
	if(customPhone==""){
		alert("客户电话不能为空");
		return;
	}
	var customAddress = $("#txtCustomerAddress").val();
	if(customAddress==""){
		alert("客户地址不能为空");
		return;
	}
	var content= $("#txtTaskDescription").val();
	if(content==""){
		alert("记录内容不能为空");
		return;
	}
	var taskTypeId = $("#selectchoicea").val();
	var taskTypeName = $("#selectchoicea").find("option:selected").text();
	if(taskTypeId==""||taskTypeName==""){
		alert("请选择记录类型");
		return;
	}
	var taskTime = $("#txtTaskTime").val();
	if(taskTime==""){
		alert("请选择记录时间");
		return;
	} 
	var Task = {};
	Task.personName= customName;
	Task.phoneNo = customPhone;
	//var TaskType ={};
	//TaskType.id = taskTypeId;
	//TaskType.name = taskTypeName;
	//Task.taskType = TaskType;
	Task.address = customAddress;
	//Task.taskTime= taskTime;
	//Task.description = content;
	alert(taskTime+"---"+taskTypeId+"---"+taskTypeName); 
	alert("ssssssssss");
	$.ajax({
		url: "Task/getTaskById.do",
        type: "POST",
        dataType: "json",
        async:false, 
        data:{id:2},
		//contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		success: function (req) {  
			
			alert(req);
		}
    });
}
