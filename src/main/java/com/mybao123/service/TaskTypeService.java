package com.mybao123.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.mybao123.dao.task.TaskTypeDao; 
import com.mybao123.model.task.TaskType;

@Service
public class TaskTypeService
{
	@Autowired
	private TaskTypeDao taskTypeDao;

	@Transactional
	public void saveTaskType(TaskType taskType)
	{
		taskTypeDao.saveOrUpdate(taskType);
	}

	@Transactional
	public List<TaskType> loadList()
	{
		String hql = " select * from TaskType ";
		List<TaskType> taskTypeList = taskTypeDao.loadList(hql);
		return taskTypeList;
	}
}