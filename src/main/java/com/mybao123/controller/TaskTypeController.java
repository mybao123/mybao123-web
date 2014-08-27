package com.mybao123.controller;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybao123.model.task.TaskType;
import com.mybao123.service.TaskTypeService;

@Controller
@RequestMapping("/TaskType")
public class TaskTypeController
{
	@Autowired
	private TaskTypeService taskTypeService;

	/**
	 * 获取TaskType下拉列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "getTaskType.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody
	String getTaskType() throws Exception
	{
		String retStr = "";
		List<JSONObject> objList = new ArrayList<JSONObject>();
		try
		{
			List<TaskType> taskTypeList = new ArrayList<TaskType>();
			taskTypeList = taskTypeService.loadList();
			if (taskTypeList.size() > 0)
			{
				for (int i = 0; i < taskTypeList.size(); i++)
				{
					JSONObject obj = new JSONObject();
					obj.accumulate("id", taskTypeList.get(i).getId());
					obj.accumulate("text", taskTypeList.get(i).getName());
					objList.add(obj);
				}
			}
			retStr = JSONObject.fromObject(objList).toString();
			return retStr;
		} 
		catch (Exception ex)
		{
			return retStr;
		}
	}
}