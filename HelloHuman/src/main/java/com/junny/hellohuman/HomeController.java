package com.junny.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HomeController {
	// Routing using @RequestParam annotation
    @RequestMapping("/")
    public String index(@RequestParam(value="q", required=false) String searchQuery) {
    	if (searchQuery == null) {
    		return "<div><h1>Hello Human!</h1><p>Welcome to springboot!</p></div>";
    	} else { 
        return "Hello " + searchQuery + "!"; // http://localhost:8080/?q=junny
    	}
    }
}