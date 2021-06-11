package com.junny.gettingfamiliarwithrouting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class DojoController {
	@RequestMapping("/dojo") // this needs to be "", not "/"
    public String dojo(){
	      return "Dojo is awesome";
	}
	@RequestMapping("/burbank-dojo/")
    public String burbankDojo(){
	      return "Burbank Dojo is located in SoCal!";
	}
	@RequestMapping("/san-jose/")
    public String sandJoseDojo(){
	      return "SJ dojo is the HQ!";
	}
}

