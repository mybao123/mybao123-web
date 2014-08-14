package com.mybao123.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
 
@Controller
@RequestMapping("/index")
public class IndexController {
 
	
	@RequestMapping(value="loadData.do",produces="application/json;charset=UTF-8")
	public @ResponseBody String LoadData() throws Exception
	{
		try
		{    
			return "";
		}catch(Exception ex)
		{
			throw ex;
		}
		
	}
	 
}


