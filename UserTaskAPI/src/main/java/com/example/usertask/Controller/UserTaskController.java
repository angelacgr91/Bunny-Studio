package com.example.usertask.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.usertask.Model.UserTask;
import com.example.usertask.Service.UserTaskService;

@RestController 
@RequestMapping("/")
public class UserTaskController {
	
	@Autowired
	private UserTaskService userTaskService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/usertasks")
	public List<UserTask> getUserTaskByUserId()
	{
		return userTaskService.findAll();
	}
	
	@PostMapping("/userstasks")
	public UserTask createTask(@Valid @RequestBody UserTask userTask)
	{
		return userTaskService.saveUserTask(userTask);
	}
	
	@PutMapping("/usertasks/{id}")
	public ResponseEntity<UserTask> updateUserTask(@PathVariable(value="id") Long userTaskId, @Valid @RequestBody UserTask userTaskDetails)
	{
		UserTask userTask = userTaskService.findById(userTaskId);
		userTask.setDescription(userTaskDetails.getDescription());
		userTask.setState(userTaskDetails.isState());
		userTask.setUserId(userTaskDetails.getUserId());
		
		UserTask updatedUserTask = userTaskService.saveUserTask(userTask);
		return ResponseEntity.ok(updatedUserTask);
	}
	

}
