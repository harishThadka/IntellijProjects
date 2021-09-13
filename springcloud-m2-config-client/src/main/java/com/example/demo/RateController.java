package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class RateController {
	
	String rate;
	String lanecount;
	String tollstart;
	
	public String getRate(Model m) {
		m.addAttribute("lanes",lanes);
	}

}
