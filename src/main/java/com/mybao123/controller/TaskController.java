package com.mybao123.controller;
 
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
  
import com.mybao123.model.task.Task;
import com.mybao123.model.user.User;
import com.mybao123.service.TaskService;
import com.mybao123.util.JsonUtils;
import com.mybao123.util.PageInfo;

@Controller
@RequestMapping("/Task")
public class TaskController
{ 
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value="saveTask.do",produces="application/json;charset=UTF-8")
	public @ResponseBody String saveTask(Task task) throws Exception
	{
		if (task == null)
		{
			return JsonUtils.getJsonObject("[]", false, "数据传输错误");
		}
		if ("".equals(task.getPersonName()) || task.getPersonName() == null)
		{
			return JsonUtils.getJsonObject("[]", false, "客户名称不能为空");
		}
		if ("".equals(task.getPhoneNo()) || task.getPhoneNo() == null)
		{
			return JsonUtils.getJsonObject("[]", false, "客户联系方式不能为空");
		}
		if ("".equals(task.getDescription()) || task.getDescription() == null)
		{
			return JsonUtils.getJsonObject("[]", false, "内容描述不能为空");
		} 
		if ("".equals(task.getAddress()) || task.getAddress() == null)
		{
			return JsonUtils.getJsonObject("[]", false, "记录地址不能为空");
		} 
//		if (task.getTaskType()==null)
//		{
//			return JsonUtils.getJsonObject("[]", false, "记录类型不能为空");
//		}
		if (task.getTaskTime()==null)
		{
			return JsonUtils.getJsonObject("[]", false, "记录时间不能为空");
		}
		try
		{  
			//获取当前时间，作为创建时间 
			Date createDate = JsonUtils.getCreateDate();
			task.setCreateTime(createDate);
			taskService.saveTask(task); 
			String jsStr = JSONObject.fromObject(task).toString();
			return JsonUtils.getJsonObject(jsStr, false, "工作记录保存成功");
		}
		catch(Exception ex)
		{
			return JsonUtils.getJsonObject("[]", false, ex.getMessage());
		}
	}
	@RequestMapping(value="deleteTask.do",produces="application/json;charset=UTF-8")
	public @ResponseBody String deleteTask(long id) throws Exception
	{
		if(id==0) 
		{
			return JsonUtils.getJsonObject("[]", false, "传输数据错误，删除失败");
		}
		try
		{ 
			taskService.deleteById(id);  
			return JsonUtils.getJsonObject("", true, "日志记录信息删除成功"); 
		}
		catch(Exception ex)
		{
			return JsonUtils.getJsonObject("[]", false, ex.getMessage());
		}
	}
	@RequestMapping(value="getTaskById.do",produces="application/json;charset=UTF-8")
	public @ResponseBody String getTaskById(long id) throws Exception
	{ 
		if(id==0) 
		{
			return JsonUtils.getJsonObject("[]", false, "传输数据错误，获取失败");
		}
		try
		{
			Task task = new Task(); 
			task = taskService.loadById(id);
			if (task == null)
			{
				return JsonUtils.getJsonObject("[]", false, "日志记录信息获取失败");
			}
			String jsStr = JSONObject.fromObject(task).toString();
			return JsonUtils.getJsonObject(jsStr, true, "日志记录信息获取成功"); 
		}
		catch(Exception ex)
		{
			return JsonUtils.getJsonObject("[]", false, ex.getMessage());
		}
	}
	@RequestMapping(value="loadTaskListWithPage.do",produces="application/json;charset=UTF-8")
	public @ResponseBody String loadListWithPage() throws Exception
	{
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		PageInfo page = new PageInfo();
		int pageIndex = 1;
		int pageSize =20; 
		int totalCount =0;
		String ObjectStr="[]";
		String pgindex = request.getParameter("page");
		String rows=request.getParameter("rows");
		if(pgindex.length()>0)
		{
			pageIndex =  Integer.parseInt(pgindex);
		}
		if(rows.length()>0)
		{
			pageSize = Integer.parseInt(rows);
		}
		page.setCurPage(pageIndex);
		page.setPageSize(pageSize);
		User user = (User)request.getSession().getAttribute("users");
		if(user==null)
		{
			return JsonUtils.getJsonObject(0,ObjectStr, false, "用户登录过期，请退出重新登录");
		}
		try
		{ 
			List<Task> taskList =taskService.loadListWithPage(page,user.getId());
			if(taskList.size()>0)
			{
				totalCount= page.getTotalRow();
				ObjectStr =  JSONObject.fromObject(taskList).toString(); 
			} 
			return JsonUtils.getJsonObject(totalCount,ObjectStr, true, "获取记录列表成功");
		}
		catch(Exception ex)
		{
			return JsonUtils.getJsonObject(0,ObjectStr, false, ex.getMessage()); 
		}
	}
	@RequestMapping(value="loadTaskList.do",produces="application/json;charset=UTF-8")
	public @ResponseBody String loadList() throws Exception
	{
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();    
		int totalCount =0;
		String ObjectStr="[]";
		User user = (User)request.getSession().getAttribute("users");
		if(user==null)
		{ 
			return JsonUtils.getJsonObject(0,ObjectStr, false, "用户登录过期，请退出重新登录");
		}
		try
		{ 
			List<Task> taskList =taskService.loadList(user.getId());
			if(taskList.size()>0)
			{
				totalCount= taskList.size();
				ObjectStr =  JSONObject.fromObject(taskList).toString(); 
			} 
			return JsonUtils.getJsonObject(totalCount,ObjectStr, true, "获取记录列表成功");
		}
		catch(Exception ex)
		{
			return JsonUtils.getJsonObject(0,ObjectStr, false, ex.getMessage()); 
		}
	}
}
