<html>
<head>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="mobile/css/jquery.mobile-1.4.3.min.css" rel="stylesheet" />
	<script src="script/base/jquery-1.11.1.min.js" type="text/javascript"></script>
	<script src="script/base/jquery.mobile-1.4.3.min.js" type="text/javascript"></script>
	<script src="script/base/json2.js" type="text/javascript"></script>
	<script src="script/base/Barrett.js" type="text/javascript"></script>
	<script src="script/base/BigInt.js" type="text/javascript"></script>
	<script src="script/base/RSA.js" type="text/javascript"></script>
	<script src="script/index.js" type="text/javascript"></script> 
</head> 
<body>  
<h2>你好！</h2> 
 <div style="display:none">
 <input id="txtSerialNo" type="text" disabled="disabled"/>
  <input id="txtuserName"  type="text" />
   <input id="txtpassWord"  type="text" />
    <input id="txtpassWord1"  type="text" />
    <input id="txtemail"  type="text" /> 
 </div>
 <div>
 <table>
 <tr>
 	<td><label>名称:</label></td>
 	<td><input  name="textinput-s" id="txtCustomerName"  type="text"  placeholder="请输入客户名称" value="" data-clear-btn="true" /></td>
 	 </tr>
 <tr>
 	<td><label>电话:</label></td>
 	<td><input  name="textinput-s"  id="txtCustomerphone"  type="text"  placeholder="" value="" data-clear-btn="true"  /></td>
 </tr>
 <tr>
 	<td><label>地址:</label></td>
 	<td><input  name="textinput-s"  style="width:70%" id="txtCustomerAddress"  type="search"   placeholder="" value="" data-clear-btn="true"  /></td> 
</tr>
 <tr style="height:20px"> 
	<td></td>
 	<td><input  name="textinput-s"  id="txtCustomerAddress"  type="button"   placeholder="" value="获取地址" data-clear-btn="true"  /></td> 
</tr>
 <tr>
 	<td><label>类型:</label></td>
 	<td>
	 	<div data-role="fieldcontain"> 
	        <select name="select-choice-a" id="select-choice-a" data-native-menu="false">
	               <option value="1">电话约访问候</option>
	         	   <option value="2">收集准主顾或准增员名单</option>
	    		   <option value="3">接触面谈保险</option>
	               <option value="5">促成签单</option>
	               <option value="3">增员面谈</option>
	               <option value="5">增员上编</option>
	               <option value="3">递交保单</option>
	               <option value="0.2">短息微信消息单向发送</option>
	               <option value="1">短信微信消息双向发送</option> 
	        </select>
		</div> 
    </td>  
 </tr>
 <tr>
 	<td><label>内容:</label></td>
 	<td><textarea cols="40" rows="8" id="txtTaskDescription" name="textarea" id="textarea"></textarea></td>  
 </tr>
 <tr>
 	<td><label>时间:</label></td>
 	<td><input id="txtTaskDescription" type="date"  placeholder="" value="" data-clear-btn="true"  /></td>  
 </tr>
 </table>
<div data-role="fieldcontain">
        <button type="submit" data-theme="b">提交</button>
 </div>
 </div>
</body>
</html>
