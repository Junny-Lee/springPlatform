package com.junny.beltExam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.junny.beltExam.models.Task;
import com.junny.beltExam.models.User;
import com.junny.beltExam.repositories.TaskRepository;
import com.junny.beltExam.repositories.UserRepository;

@Service
public class TaskService {
 // adding the task repository as a dependency
 private final TaskRepository taskRepository;
 private final UserRepository userRepository;
 
 public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
     this.taskRepository = taskRepository;
     this.userRepository = userRepository;
 }
 // returns all the tasks
 public List<Task> allTasks() {
     return taskRepository.findAll(); // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference 
 }
 // creates a task
 public Task createTask(Task n) {
     return taskRepository.save(n); // save() fn from extending from Crud
 }
 // retrieves a task
 public Task findTask(Long id) {
     Optional<Task> optionalTask = taskRepository.findById(id); // Optional is saying "if it is here, i'll get you the task"
     if(optionalTask.isPresent()) {
         return optionalTask.get();
     } else {
         return null;
     }
 }
 // updates a task
 public Task updateTask(Long id, String job, User creator, String assignee, String priority) {
 	Task task = findTask(id);
 	task.setJob(job);
 	task.setCreator(creator);
 	task.setAssignee(assignee);
 	task.setPriority(priority);
 	return taskRepository.save(task);
 }
 
 public Task updateTask(Task n) {
 	return taskRepository.save(n);
 }
 
 // deletes a task
 public void deleteTask(Long id) {
 	taskRepository.deleteById(id);
 }
}


