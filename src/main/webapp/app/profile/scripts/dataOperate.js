function loginAction() {
	var userName = Ext.getCmp("userName").getValue();
	var password = Ext.getCmp("password").getValue();
	var email = Ext.getCmp("email").getValue();
	var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	;
	if (userName == "") {
		Ext.Msg.alert('错误提示', '请输入账号', Ext.emptyFn);
		return;
	}
	if (password == "") {
		Ext.Msg.alert('错误提示', '请输入密码', Ext.emptyFn);
		return;
	}
	if (email == "") {
		Ext.Msg.alert('错误提示', '请输入邮箱地址', Ext.emptyFn);
		return;
	}
	if (!reg.test(email)) {
		Ext.Msg.alert('错误提示', '请输入正確的邮箱地址', Ext.emptyFn);
		return;
	}
	var module = '88f6ae182d92151ed240e0c7f51136144609dd5ced49f28171ef33af1e3b1d64c7b5939bc0b12e22f3a046168f8890371555e933a2a5714f7b3a858946eea17f';
	var empoent = '10001';
	setMaxDigits(131); // 131 => n的十六进制位数/2+3
	var key = new RSAKeyPair(empoent, '', module); // 10001 => e的十六进制
	epwd = encryptedString(key, password);
	var user = {};
	user.name = userName;
	user.psd = epwd;
	user.email = email;
	$.ajax({
		url : "Login/userLogin.do",
		type : "POST",
		dataType : "json",
		async : false,
		data : user,
		// contentType: "application/x-www-form-urlencoded; charset=utf-8",
		success : function(req) {
			if (req.IsSucceed) {
				Ext.Msg.alert('Success', req.Message, Ext.emptyFn);
			} else {
				Ext.Msg.alert('错误提示', req.Message, Ext.emptyFn);
			}
		},
		failure : function(a, b) {
			Ext.Msg.alert('错误提示f', a.Message, Ext.emptyFn);
		},
		error : function(data, options) {
			Ext.Msg.alert('错误提示e', "404", Ext.emptyFn);
		}
	});
}