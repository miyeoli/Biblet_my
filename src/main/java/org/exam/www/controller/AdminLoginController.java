package org.exam.www.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.exam.www.exception.IdPasswordNotMatchingException;
import org.exam.www.model.CommandAdminAuthInfo;
import org.exam.www.model.CommandAdminLogin;
import org.exam.www.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class AdminLoginController {
	
	private LoginService loginService;
	
	@Autowired
	public void setadminService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	//login
	@RequestMapping(value="/adminlogin", method=RequestMethod.GET)
    public String form(CommandAdminLogin adminloginCommand) throws Exception {    
        return "/adminlogin";
    }

	@RequestMapping(value="/adminlogin",method=RequestMethod.POST)
	public String submit(@Validated @ModelAttribute("AdminLoginCommand")CommandAdminLogin adminloginCommand, 
            HttpSession session, HttpServletResponse response, Errors errors) throws Exception {
		new AdminLoginCommandValidator().validate(adminloginCommand, errors);
		
		if(errors.hasErrors()) {
			System.out.println("실패");
			return "/adminlogin";
		}
		
		try {
			System.out.println(adminloginCommand.getAdm_id());
			System.out.println(adminloginCommand.getAdm_pass());
			
			
			
			CommandAdminAuthInfo adminauthInfo = loginService.adminauthenticate(
					adminloginCommand.getAdm_id(), 
					adminloginCommand.getAdm_pass());
			
			//세션에 adminauthInfo저장
			session.setAttribute("adminauthInfo", adminauthInfo);
			
			
			
			
			//return "loginSuccess";
<<<<<<< HEAD
			//관리자 로그인 성공시 관리자 페이지로 이동
=======
			//로그인 성공 시 관리자 페이지
>>>>>>> 37b08e76a3ade3cc066d049aafe0b085fb59deff
			System.out.println("성공");
			return "/loginSuccess";
			
			
			} catch (IdPasswordNotMatchingException e) {
				errors.reject("IdPasswordMatching");
				System.out.println("오류");
				return "/adminlogin";
			}
	}
	
//	//logout
//	@RequestMapping(value="/logout", method=RequestMethod.GET)
//	public String logout(HttpSession session) {
//		session.invalidate(); //세션 제거
//		return "redirect:/main";
//	}
		
	

}
