package com.mybao123.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybao123.dao.Page;
import com.mybao123.dao.task.TaskDao;
import com.mybao123.dao.task.TaskTypeDao;
import com.mybao123.model.task.Task;
import com.mybao123.model.task.TaskType;

@Service
public class TaskService
{
	@Autowired
	private TaskDao taskDao;
	
	@Autowired
	private TaskTypeDao taskTypeDao;
	
	@Transactional
	public void saveTask(Task task)
	{
		taskDao.saveOrUpdate(task);
	}

	@Transactional
	public void delete(Task task)
	{
		taskDao.delete(task);
	}
	@Transactional
	public void deleteById(long id)
	{
		taskDao.delete(id);
	}
	@Transactional
	public Task loadById(long id)
	{
		Task task = new Task();
		task=taskDao.loadById(id);
		return task;
	}
	
	@Transactional
	public List<Task> loadListWithPage(Page page,long userid)
	{  
		 String hql =String.format(" from Task where user.Id ={0} ",userid); 
		 List<Task> taskList = taskDao.loadListWithPage(hql, page);
		 return taskList;
	}
	@Transactional
	public List<Task> loadList(long userid)
	{  
		 String hql =String.format(" from Task where user.Id ={0} ",userid); 
		 List<Task> taskList = taskDao.loadList(hql);
		 return taskList;
	}
	
	@Transactional
	public void saveTaskType(TaskType taskType)
	{
		taskTypeDao.saveOrUpdate(taskType);
	}
	 
}
