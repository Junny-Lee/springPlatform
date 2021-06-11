package com.junny.gettingfamiliarwithrouting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/coding")
public class CodingController {
	@RequestMapping("") // this needs to be "", not "/"
    public String coding(){
	      return "Hello coding dojo!";
	}
	@RequestMapping("/python")
    public String codingPython(){
	      return "Python/Django was awesome!!";
	}
	@RequestMapping("/java")
    public String codingJava(){
	      return "Java/Spring is better!";
	}
}
