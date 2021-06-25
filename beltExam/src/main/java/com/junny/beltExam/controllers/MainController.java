package com.junny.beltExam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.junny.beltExam.models.Task;
import com.junny.beltExam.models.User;
import com.junny.beltExam.services.TaskService;
import com.junny.beltExam.services.UserService;
import com.junny.beltExam.validator.UserValidator;

@Controller
public class MainController {
	 private final UserService userService;
	 private final UserValidator userValidator;
	 private final TaskService taskService;
 
	 public MainController(UserService userService, UserValidator userValidator, TaskService taskService) {
	        this.userService = userService;
	        this.userValidator = userValidator;
	        this.taskService = taskService;
	    }
	 
	 @RequestMapping("/")
	 public String registrationAndLogin(@ModelAttribute("user") User user) {
	     return "loginRegPage.jsp";
	 }
	 
	 @RequestMapping(value="/registration", method=RequestMethod.POST)
	 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		 // if result has errors, return the registration page (don't worry about validations just now)
	     // else, save the user in the database, save the user id in session, and redirect them to the /home route
		 userValidator.validate(user, result);
		 if(result.hasErrors()) {
			 return "loginRegPage.jsp";
		 }
		 User u = userService.registerUser(user);
		 session.setAttribute("userId", u.getId());
		 return "redirect:/tasks";
	 }
	 
	 @RequestMapping(value="/login", method=RequestMethod.POST)
	 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
	     // if the user is authenticated, save their user id in session
	     // else, add error messages and return the login page
		 boolean isAuthenticated = userService.authenticateUser(email, password);
		 if (isAuthenticated) {
			 User u = userService.findByEmail(email);
			 session.setAttribute("userId", u.getId());
			 return "redirect:/tasks";
		 } else {
			 model.addAttribute("error", "Invalid Credentials. Please try again.");
			 return "loginRegPage.jsp";
		 }
	 }
	 
	 @RequestMapping("/tasks")
	 public String home(HttpSession session, Model model) {
	     // get user from session, save them in the model and return the home page
		 Long userId = (Long) session.getAttribute("userId");
		 User u = userService.findUserById(userId);
		 model.addAttribute("user", u);
		 List<Task> tasks = taskService.allTasks();
		 model.addAttribute("tasks", tasks);
		 return "tasks.jsp";
	 }
	 @RequestMapping("/logout")
	 public String logout(HttpSession session) {
	     // invalidate session
	     // redirect to login page
		 session.invalidate();
		 return "redirect:/";
	 }
	 
	 @RequestMapping("/tasks/new") // CREATE
	 public String newTask(@ModelAttribute("task") Task task, Model model, HttpSession session) {
		 List<User> users = userService.allUsers();
		 model.addAttribute("users", users);
		 Long userId = (Long) session.getAttribute("userId");
		 User user = userService.findUserById(userId);
		 model.addAttribute("user", user);
	     return "createTask.jsp";
	 }

	 @RequestMapping(value="/tasks/create", method=RequestMethod.POST) // NEW // long hand
	 public String create(@Valid @ModelAttribute("task") Task task, BindingResult result, Model model) {
	     if (result.hasErrors()) {
	    	 List<User> users = userService.allUsers();
			 model.addAttribute("users", users);
	         return "createTask.jsp";
	     } else {
	    	 User taskCreator = task.getCreator();
	    	 System.out.println(taskCreator);
	         taskService.createTask(task);
	         return "redirect:/tasks";
	     }
	 }
	 
	 @RequestMapping("/tasks/{id}") // READ ONE
	 public String show(Model model, @PathVariable("id") Long id) {
		 Task task = taskService.findTask(id);
		 model.addAttribute("task", task);
		 return "show.jsp";
	 }
	 
	 @RequestMapping("/tasks/{id}/edit") // display jsp file 
	 public String edit(@PathVariable("id") Long id, Model model) {
	     Task task = taskService.findTask(id);
	     model.addAttribute("task", task);
	     List<User> users = userService.allUsers();
		 model.addAttribute("users", users);
	     return "editTask.jsp";
	 }
	 
	 @RequestMapping(value="/tasks/{id}/process", method=RequestMethod.PUT) // actually doing the put
	 public String update(@Valid @ModelAttribute("task") Task task, BindingResult result, HttpSession session) {
	     if (result.hasErrors()) {
	    	 System.out.println(result.getAllErrors());
	         return "editTask.jsp";
	     } else {
	    	 task.setCreator(userService.findUserById((Long)session.getAttribute("userId"))); // need to cast 
	    	 taskService.updateTask(task);
	         return "redirect:/tasks";
	     }
	 }
	 
}
