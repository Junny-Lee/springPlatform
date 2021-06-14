package com.junny.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(value="/check", method=RequestMethod.POST)
	public String home(@RequestParam(value="code") String code, RedirectAttributes redirectAttributes) {
		if (code.equals("bushido")) { // .equals() not ==
			return "redirect:/code";
		}
		redirectAttributes.addFlashAttribute("error", "You must train harder!");
		return "redirect:/";
	}
	@RequestMapping("/code")
	public String code() {
		return "code.jsp";
	}
}
