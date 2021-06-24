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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.junny.eventsBeltReviewer.models.Event;
import com.junny.eventsBeltReviewer.models.Message;
import com.junny.eventsBeltReviewer.models.User;
import com.junny.eventsBeltReviewer.services.EventService;
import com.junny.eventsBeltReviewer.services.MessageService;
import com.junny.eventsBeltReviewer.services.UserService;
import com.junny.eventsBeltReviewer.validator.UserValidator;

@Controller
public class MainController {
	 private final UserService userService;
	 private final UserValidator userValidator;
	 private final EventService eventService;
	 private final MessageService messageService;
 
	 public MainController(UserService userService, UserValidator userValidator, EventService eventService, MessageService messageService) {
	        this.userService = userService;
	        this.userValidator = userValidator;
	        this.eventService = eventService; 
	        this.messageService = messageService;
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
			 //System.out.println(result.getFieldErrors());
			 return "homePage.jsp";
		 }
//		 System.out.println(date);
		 Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		 event.setDate(d);
		 eventService.createEvent(event);
		 return "redirect:/events";
	 }
	 
	 @RequestMapping("/events/{eventId}")
	 public String eventPage(HttpSession session, Model model, @PathVariable("eventId") Long eventId) {
	     // get user from session, save them in the model and return the home page
		 Long userId = (Long) session.getAttribute("userId");
		 User u = userService.findUserById(userId);
		 Event e = eventService.findEvent(eventId);
		 List<Message> comments = e.getComments(); // for messages
		 model.addAttribute("event", new Event()); // look at this line!
		 model.addAttribute("user", u);
		 model.addAttribute("e", e);
		 model.addAttribute("comments", comments);
		 model.addAttribute("message", new Message()); // create new message
		 return "eventPage.jsp";
	 }
	 
	 @RequestMapping("/events/{id}/edit") // display jsp file 
	 public String edit(@PathVariable("id") Long id, Model model) {
	     Event event = eventService.findEvent(id);
	     model.addAttribute("event", event);
	     return "editEvent.jsp";
	 }
	 
	 @RequestMapping(value="/events/{id}/process", method=RequestMethod.PUT) // actually doing the put
	 public String update(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session,
			 			@RequestParam("date2") String date) throws ParseException {
	     if (result.hasErrors()) {
	    	 System.out.println(result.getAllErrors());
	         return "editEvent.jsp";
	     } else {
	    	 event.setCreator(userService.findUserById((Long)session.getAttribute("userId"))); // need to cast 
	    	 Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			 event.setDate(d);
	    	 eventService.updateEvent(event);
	         return "redirect:/events";
	     }
	 }

	 @RequestMapping(value="/events/{id}/delete") // delete
	 public String destroy(@PathVariable("id") Long id) {
	     eventService.deleteEvent(id);
	     return "redirect:/events";
	 }
	 
	 // created this
	 // allows Users to join Events
	 @RequestMapping(value="/join/{id}")
	 public String join(@PathVariable("id") Long eventId, HttpSession session) {
		 Event event = eventService.findEvent(eventId);
		 event.getJoinedUsers().add(userService.findUserById((Long)session.getAttribute("userId")));
		 eventService.updateEvent(event);
		 return "redirect:/events/" + event.getId();	// look at this!!!!!!
	 }	
	 
	 // created this 
	 // allows Users to make comments
	 @RequestMapping(value="/comment", method=RequestMethod.POST)
	 public String comment(@Valid @ModelAttribute("message") Message comment, BindingResult result, 
			 				Model model, HttpSession session ) {
		 if(result.hasErrors()) {
			 System.out.println(result.getFieldErrors());
			 return "eventPage.jsp";
		 } else {
			 messageService.createMessage(comment); // the object
			 return "redirect:/events/" + comment.getEvent().getId();
		 }
	 }
	 // ways to get event id:
	 // 1. the way we did it here
	 // 2. get rid of <form> and just make the form: hidden a  input type=hidden with "name" instead of "path" && and then do @RequestParam in the controller and target the "name" 
	 // 3. @PathVariable and have action="/comment/{eventId}
}

