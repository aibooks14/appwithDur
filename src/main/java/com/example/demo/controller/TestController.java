package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/first")
public class TestController {
	
	
//	This is for sending data from controller to view----------
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("name", "Sagar Gandhi") ;
		System.out.println("This is for home page");
		List<String> friends = new ArrayList<String>() ;
		friends.add("Taro") ;
		friends.add("Tanaka") ;
		model.addAttribute("friends", friends) ;
		return "index" ;
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("message", "Hello From About controller") ;
		System.out.println("This is for about page");
		return "about" ;
	}
	
	@GetMapping("/help")
	public ModelAndView help() {
		ModelAndView modelview = new ModelAndView();
		modelview.addObject("name", "SAGAR") ;
		modelview.addObject("roll_number",123) ;
		modelview.setViewName("help") ;
		LocalDateTime now = LocalDateTime.now() ;
		modelview.addObject("time", now) ;
		
		System.out.println(now.toString());
		return modelview ;
	}
	
//	This is for sending data from controller to view----------
	
//	Now sending data from view to controller---------------
	
	
	
	
	
	
	
//	Now sending data from view to controller---------------
}
