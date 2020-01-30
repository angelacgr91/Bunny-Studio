package com.example.usertask.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usertask.Model.UserTask;
import com.example.usertask.Repository.UserTaskRepository;

@Service
public class UserTaskService {
	
	@Autowired
    private UserTaskRepository userTaskRepository;

	public List<UserTask> findAll() {
		
		Iterable<UserTask> list = userTaskRepository.findAll();

	        ArrayList<UserTask> userTasks = new ArrayList<UserTask>();
	        list.forEach(e -> userTasks.add(e));
		return userTasks;
	}

	public UserTask saveUserTask(UserTask userTask) {	
		return userTaskRepository.save(userTask);
	}

	public UserTask findById(Long userTaskId) {
		Optional<UserTask> optionalUserTask = userTaskRepository.findById(userTaskId);
		UserTask userTask = optionalUserTask.get();
		
		return userTask;
	}

}
