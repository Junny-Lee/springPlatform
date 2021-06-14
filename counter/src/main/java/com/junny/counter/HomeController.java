package com.junny.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home(HttpSession session) {
		if (session.getAttribute("counter") == null) {
			session.setAttribute("counter", 0); // set attribute to 0
		}
		session.setAttribute("counter", ((Integer)session.getAttribute("counter")+1)); // used to set attribute 
		return "index.jsp";
//		Integer views = (Integer) session.getAttribute("pageViews");
//		if (views == null) {
//			session.setAttribute("pageViews", 0); // set attribute to 0
//			views = 0;	// set variable, views, to 0
//		}
//		views++; // used to set attribute 
//		session.setAttribute("pageViews",views);
//		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		session.getAttribute("c");
		return "counter.jsp";
	}
	@RequestMapping("/clear")
	public String clear(HttpSession session) {
		session.setAttribute("counter", null);
		return "redirect:/";
	}
}

