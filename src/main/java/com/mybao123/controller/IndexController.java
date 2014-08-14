package com.mybao123.controller;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybao123.model.user.User;
import com.mybao123.service.IndexService;

@Controller
@RequestMapping("/index")
public class IndexController {

	@Autowired
	private IndexService indexService;
	
	@RequestMapping(value="loadData.do",produces="application/json;charset=UTF-8")
	public @ResponseBody String LoadData() throws Exception
	{
		try
		{
			
			if(indexService != null){
				indexService.addUser("lrj", "abc");
			}
				
			User u=new User();

			u.setName("’–…Ã“¯––");

			
			String json=JSONObject.fromObject(u).toString();
		
		
		return json;
		}catch(Exception ex)
		{
			throw ex;
		}
		
	}	
}
