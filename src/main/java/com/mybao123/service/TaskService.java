package com.mybao123.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybao123.dao.task.TaskDao;
import com.mybao123.model.task.Task;

@Service
public class TaskService
{
	@Autowired
	private TaskDao taskDao;
	
	@Transactional
	public void saveTask(Task task)
	{
		taskDao.saveOrUpdate(task);
	}
}
