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
 
 <input id="txtSerialNo" class="easyui-validatebox" data-options="required:false" disabled="disabled"/>
  <input id="txtuserName" class="easyui-validatebox" data-options="required:false" />
   <input id="txtpassWord" class="easyui-validatebox" data-options="required:false" />
    <input id="txtpassWord1" class="easyui-validatebox" data-options="required:false" />
 
 <a id="btnLoad" href="javascript:void(0);" class="easyui-linkbutton" iconcls="icon-save" plain="true" onclick="loadAction()">保存</a>
 
</body>
</html>
