package com.junny.firstproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // allows me to respond with a template
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
}


//@RestController
//@RequestMapping("/greeting") // class level annotation. this will be appended to every route
//public class HomeController {
//	// Routing using @RequestParam annotation
//    @RequestMapping("/")
//    public String index(@RequestParam(value="q", required=false) String searchQuery) {
//    	if (searchQuery == null) {
//    		return "You searched for nothing";
//    	} else { 
//        return "You searched for: " + searchQuery; // http://localhost:8080/greeting/?q=junny
//    	}
//    }
//    // Routing using @PathVariable annotation 
//    @RequestMapping("/m/{color}/{size}/{price}") // example: http://localhost:8080/greeting/m/pink/big/one
//    public String showLesson(@PathVariable("color") String color, @PathVariable("size") String size, @PathVariable("price") String price){
//    	return "Color: " + color + ", Size: " + size + ", Price: " + price;
//    }
//    // Routing only using @RequestMapping
//    @RequestMapping("/hello")
//    public String hello(){
//      return "Hello world! What route did you use to access me?";
//    }
//    @RequestMapping("/goodbye")
//    public String world(){
//      return "Goodbye world!";
//    }
//}

// how this is mapped:
// METHOD				PATH					MET
// GET					/greeting				HomeController.index
// GET					/greeting/hello			HomeController.hello
// GET					/greeting/goodbye		HomeController.world
