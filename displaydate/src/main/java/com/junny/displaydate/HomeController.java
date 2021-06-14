package com.junny.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // allows me to respond with a template
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
//		Date date= new java.util.Date();
		String date = new SimpleDateFormat("EEEEE', the 'd' of 'MMMMM', 'y").format(new Date());
		model.addAttribute("date", date);
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		String time = new SimpleDateFormat("HH:mm aa").format(new Date());
		System.out.println(time);
		model.addAttribute("time", time);
		return "time.jsp";
	}
}
