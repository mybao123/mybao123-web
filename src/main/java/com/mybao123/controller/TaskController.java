package com.mybao123.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Task")
public class TaskController
{
	
	@RequestMapping(value="saveTask.do",produces="application/json;charset=UTF-8")
	public @ResponseBody String saveTask() throws Exception
	{
		String result=null;
		
		return result;
	}
}
