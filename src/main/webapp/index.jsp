<html>
<head>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="script/base/jquery-1.11.1.min.js" type="text/javascript"></script>
	<script src="script/base/jquery.easyui.min.js" type="text/javascript"></script>
	<script src="script/base/easyui-lang-zh_CN.js" type="text/javascript"></script>
	<script src="Script/base/jquery.artDialog.js" type="text/javascript"></script>
	<script src="script/base/json2.js" type="text/javascript"></script>
	<script src="script/base/Barrett.js" type="text/javascript"></script>
	<script src="script/base/BigInt.js" type="text/javascript"></script>
	<script src="script/base/RSA.js" type="text/javascript"></script>
	<script src="script/index.js" type="text/javascript"></script>
</head>
<body>
<h2>你好！</h2>
 <div style="display:none">
 <input id="txtSerialNo" class="easyui-validatebox" data-options="required:false" disabled="disabled"/>
  <input id="txtuserName" class="easyui-validatebox" data-options="required:false" />
   <input id="txtpassWord" class="easyui-validatebox" data-options="required:false" />
    <input id="txtpassWord1" class="easyui-validatebox" data-options="required:false" />
 </div>
 <table style="width:700px; height:200px">
 	<tr>
 		<td style="width:70px"><label>客户名称：</label></td>
 		<td style="width:160px"><input id="txtCustomerName" class="easyui-validatebox" data-options="required:false" /></td>
 		<td><label>联系方式：</label></td>
 		<td><input id="txtCustomerphone" class="easyui-validatebox" data-options="required:false" /></td>
 		<td><label>记录时间：</label></td>
 		<td><input id="txtTaskTime" class="easyui-datebox"  style="width:154px" data-options="required:false" /></td>
 	</tr> 
 	<tr>
 		<td><label>记录类型：</label></td>
 		<td colspan="5"><input id="txtTaskType" class="easyui-combobox" data-options="required:false" /></td>
	</tr> 
 	<tr>
 		<td><label>客户地址：</label></td>
 		<td colspan="5"><input id="txtCustomerAddress" type="text"  style="width:99%"  /></td>
	</tr>
	<tr>
 		<td><label>记录内容：</label></td>
 		<td colspan="5"><textarea id="txtTaskDescription"  style="width:99%" ></textarea></td>
 	</tr>
 </table>
 <a id="btnLoad" href="javascript:void(0);" class="easyui-linkbutton" iconcls="icon-save" plain="true" onclick="addTask()">保存</a>
 
</body>
</html>
