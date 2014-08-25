package com.mybao123.controller;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybao123.model.task.Task;
import com.mybao123.service.TaskService;

@Controller
@RequestMapping("/Task")
public class TaskController
{
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value="saveTask.do",produces="application/json;charset=UTF-8")
	public @ResponseBody String saveTask(Task task) throws Exception
	{
		JSONObject object = new JSONObject();  
		long taskId=0; 
		boolean IsSuceed= false; 
		String message="";
		try
		{ 
			if(task==null)
			{   
				message= "传入后台对象为空"; 
			}
			else
			{
				taskService.saveTask(task);
				taskId = task.getId();
				IsSuceed = true;
				message = "保存成功";
			}
			object.accumulate("Id", taskId);
			object.accumulate("IsSuceed", IsSuceed);
			object.accumulate("Message", message);
			String retStr = JSONObject.fromObject(object).toString(); 
			return retStr;
		}
		catch(Exception ex)
		{
			object.accumulate("Id", 0);
			object.accumulate("IsSuceed", false);
			object.accumulate("Message", ex.getMessage());
			String retStr = JSONObject.fromObject(object).toString(); 
			return retStr;
		}
	}
	@RequestMapping(value="deleteTask.do",produces="application/json;charset=UTF-8")
	public @ResponseBody String deleteTask(long id) throws Exception
	{
		JSONObject object = new JSONObject();   
		boolean IsSuceed= false; 
		String message="";
		try
		{
			if(id==0) 
			{
				message= "传入后台Id为空.";
			}
			else
			{
				taskService.deleteById(id); 
				IsSuceed = true;
				message = "删除成功";
			}
			object.accumulate("Id", id);
			object.accumulate("IsSuceed", IsSuceed);
			object.accumulate("Message", message);
			String retStr = JSONObject.fromObject(object).toString(); 
			return retStr;
		}
		catch(Exception ex)
		{
			object.accumulate("Id", id);
			object.accumulate("IsSuceed", IsSuceed);
			object.accumulate("Message", ex.getMessage());
			String retStr = JSONObject.fromObject(object).toString(); 
			return retStr;
		}
	}
	@RequestMapping(value="getTaskById.do",produces="application/json;charset=UTF-8")
	public @ResponseBody String getTaskById(long id) throws Exception
	{
		JSONObject object = new JSONObject();   
		boolean IsSuceed= false; 
		String message="";
		try
		{
			Task task = new Task();
			if(id==0) 
			{
				message= "传入后台Id为空.";
			}
			else
			{
				task=taskService.loadById(id);
				if(task!=null){
					IsSuceed = true; 
					message = JSONObject.fromObject(task).toString(); 
				}else
					message= "根据Id获取对象失败。";
			}  			 
			object.accumulate("Id", id);
			object.accumulate("IsSuceed", IsSuceed);
			object.accumulate("Message", message);
			String retStr = JSONObject.fromObject(object).toString(); 
			return retStr;			 
		}
		catch(Exception ex)
		{
			object.accumulate("Id", id);
			object.accumulate("IsSuceed", IsSuceed);
			object.accumulate("Message", ex.getMessage());
			String retStr = JSONObject.fromObject(object).toString(); 
			return retStr;
		}
	}
}
