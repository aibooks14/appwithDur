package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;



@Controller
public class FormController {
	
	/*If we want some common heading on the different web pages, we dont want to write same code in different methods , multiple times.
	 * then, we will use the annotation @ModelAttribute.
	 * Like writing below
	 * */
	
	@ModelAttribute
	public void commmonDataForModelOnDifferentWebPage(Model m) {
		m.addAttribute("Header", "This is the common Heading for the web pages of Controller Mentioned Below") ;
		m.addAttribute("description", "Thankyou") ;
		System.out.println("common method");
	}

	@GetMapping("/form")
	public String showForm() {
		return "view";
	}
	
/* Below method inputForm and inputFormByUsingModelAttribute are having same meaning.
 * with different ways.
 * */
	
	
//Sending data from view(form) to controller and further is use to save in the DB.
	//not required the create the entity class
	//Taking data from web page form
	@RequestMapping(path = "/processFormWithRequestParam", method =RequestMethod.POST)
	public String inputForm(@RequestParam("email") String email, @RequestParam("name") String name,
			@RequestParam("password") String password, Model model) {
		System.out.println(email);
		System.out.println(name);
		System.out.println(password);
		
		//Send data on web page success
		model.addAttribute("email", email);
		model.addAttribute("name", name);
		model.addAttribute("password", password);
		return "success";
	}
	
	//not required the create the entity class
	//Taking data from web page form
	@RequestMapping(path = "/processFormWithModelAttribute", method =RequestMethod.POST)
	public String inputFormByUsingModelAttribute(@RequestParam("email") String email, @RequestParam("name") String name,
			@RequestParam("password") String password, Model model) {

		
		User user = new User() ;
		user.setEmail(email) ;
		user.setName(name) ;
		user.setPassword(password) ;
		System.out.println(user);
		

		//Send data on web page success
		model.addAttribute("user", user);
;
		return "success";
	}
	
	
	//Taking data from web page form
	/*Operation is same as about but this is the shortcut way to handle the process
	 * We need to create entity class here of the name user, 
	 * above 2 methods are not required the create the entity class
	*/
	@RequestMapping(path = "/processFormWithModelAttributeAndClassObject", method =RequestMethod.POST)
	public String inputFormByUsingModelAttributeWithClassObject(@ModelAttribute User user, Model model) {

//		can delete the code of line 71, 72, 73 because using annotation [@ModelAttribute]
//		User user = new User() ;
//		user.setEmail(email) ;
//		user.setName(name) ;
//		user.setPassword(password) ;
		System.out.println(user);
		

		//Send data on web page success
//		model.addAttribute("user", user); 
;
		return "success";
	}

}
