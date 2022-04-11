package org.exam.www.controller;



import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {
	
	//logout
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		return "redirect:/main";
	}
	
	
}
	
	
