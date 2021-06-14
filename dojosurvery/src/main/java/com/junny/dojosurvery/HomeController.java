package com.junny.dojosurvery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(value="/result", method=RequestMethod.POST)
	public String result(@RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="language") String language, @RequestParam(value="comment") String comment, RedirectAttributes redirectAttributes, HttpSession session) {
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("language", language);
		session.setAttribute("comment", language);
		return "redirect:/result";
	}
}
