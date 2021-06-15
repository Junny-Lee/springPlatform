package com.junny.ninjagoldgame;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/Gold")
	public String index(HttpSession session) {
		if (session.getAttribute("gold") == null) { // need to use session
			session.setAttribute("gold", 0);
			session.setAttribute("activityArr", new ArrayList<String>());
		}
		return "index.jsp";
	}
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String process(@RequestParam(value="location") String location, HttpSession session) {
		ArrayList<String> arrayOfActivities = (ArrayList<String>) session.getAttribute("activityArr");
		String time = new SimpleDateFormat("EEEE', 'MMMMM d', 'y HH:mm aa").format(new Date());
		if (location.equals("farm")) {
			Random r = new Random();
			int amount = r.nextInt(10) + 10;
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + amount);
			arrayOfActivities.add("You entered a Farm and earned " + amount + " gold. (" + time + ")");
			session.setAttribute("activityArr", arrayOfActivities);
//			System.out.println(arrayOfActivities);
		} else if (location.equals("cave")) {
			Random r = new Random();
			int amount = r.nextInt(5) + 5;
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + amount);
			arrayOfActivities.add("You entered a Cave and earned " + amount + " gold. (" + time + ")");
			session.setAttribute("activityArr", arrayOfActivities);
//			System.out.println(arrayOfActivities);
		} else if (location.equals("house")) {
			Random r = new Random();
			int amount = r.nextInt(3) + 2;
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + amount);
			arrayOfActivities.add("You entered a House and earned " + amount + " gold. (" + time + ")");
			session.setAttribute("activityArr", arrayOfActivities);
//			System.out.println(arrayOfActivities);
		} else {
			Random r = new Random();
			int amount = r.nextInt(100) - 50;
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + amount);
			if (amount >= 0) {
				arrayOfActivities.add("<p class=\"green\">You entered a Casino and earned " + amount + " gold. (" + time + ") </p>");
			} else {
				arrayOfActivities.add("<p class=\"red\">You entered a Casino and lost " + amount + " gold. (" + time + ") </p>");
			}
			session.setAttribute("activityArr", arrayOfActivities);
//			System.out.println(arrayOfActivities);
		}
		return "redirect:/Gold";
	}
	@RequestMapping(value="/clear")
	public String clear(HttpSession session) {
		session.setAttribute("gold", null);
		return "redirect:/Gold";
	}
}
