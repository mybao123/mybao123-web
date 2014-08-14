/**
 * 
 */

$(function () {
	$('#txtSerialNo').val('1111');
	
	
});

function loadAction(){
	$.ajax({
        url: "index/loadData.do",
        type: "POST",
        dataType: "json",
        async:false,
        //contentType: "application/x-www-form-urlencoded; charset=utf-8", 
        success: function (req) {
        	var s = req;
        	$('#txtSerialNo').val(req.name + "    " + req.number) ;
        	//$('#txtSerialNo').val(req) ;
        }
    });
}
