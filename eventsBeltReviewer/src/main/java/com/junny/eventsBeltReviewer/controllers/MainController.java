package com.junny.eventsBeltReviewer.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.junny.eventsBeltReviewer.models.Event;
import com.junny.eventsBeltReviewer.models.User;
import com.junny.eventsBeltReviewer.services.EventService;
import com.junny.eventsBeltReviewer.services.UserService;
import com.junny.eventsBeltReviewer.validator.UserValidator;

@Controller
public class MainController {
	 private final UserService userService;
	 private final UserValidator userValidator;
	 private final EventService eventService;
 
	 public MainController(UserService userService, UserValidator userValidator, EventService eventService) {
	        this.userService = userService;
	        this.userValidator = userValidator;
	        this.eventService = eventService; 
	    }
	 
	 @RequestMapping("/")
	 public String registerFormAndLogin(@ModelAttribute("user") User user) {
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
		 return "redirect:/events";
	 }
	 
	 @RequestMapping(value="/login", method=RequestMethod.POST)
	 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
	     // if the user is authenticated, save their user id in session
	     // else, add error messages and return the login page
		 boolean isAuthenticated = userService.authenticateUser(email, password);
		 if (isAuthenticated) {
			 User u = userService.findByEmail(email);
			 session.setAttribute("userId", u.getId());
			 return "redirect:/events";
		 } else {
			 model.addAttribute("error", "Invalid Credentials. Please try again.");
			 return "loginRegPage.jsp";
		 }
	 }
	 
	 @RequestMapping("/events")
	 public String home(HttpSession session, Model model) {
	     // get user from session, save them in the model and return the home page
		 Long userId = (Long) session.getAttribute("userId");
		 User u = userService.findUserById(userId);
		 List<Event> eventsInSameState = eventService.findByState(u.getState()); // for first table
		 List<Event> eventsInOtherStates = eventService.findByStateNotContaining(u.getState());
		 model.addAttribute("event", new Event()); // look at this line!
		 model.addAttribute("user", u);
		 model.addAttribute("eventsInSameState", eventsInSameState);
		 model.addAttribute("eventsInOtherStates", eventsInOtherStates);
		 return "homePage.jsp";
	 }
	 @RequestMapping("/logout")
	 public String logout(HttpSession session) {
	     // invalidate session
	     // redirect to login page
		 session.invalidate();
		 return "redirect:/";
	 }
	 
	 @RequestMapping(value="/createEvent", method=RequestMethod.POST)
	 public String createNew(@Valid @ModelAttribute("event") Event event, BindingResult result, 
			 				Model model, HttpSession session,
			 				@RequestParam("date1") String date) throws ParseException {
		 if(result.hasErrors()) {
			 System.out.println(result.getFieldErrors());
			 return "homePage.jsp";
		 }
		 System.out.println(date);
		 Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		 event.setDate(d);
		 eventService.createEvent(event);
		 return "redirect:/events";
	 }
}












