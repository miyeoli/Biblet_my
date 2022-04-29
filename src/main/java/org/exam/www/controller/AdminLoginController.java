package org.exam.www.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.exam.www.model.AdminVO;
import org.exam.www.service.AdminAuthInfo;
import org.exam.www.service.AdminService;
import org.exam.www.service.UserService;
import org.exam.www.util.IdPasswordNotMatchingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminLoginController {
	
	
	private AdminService adminService;
	
	@Autowired
	public void setadminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	//login
	@RequestMapping(value="/adminlogin", method=RequestMethod.GET)
    public String form(AdminLoginCommand adminloginCommand) throws Exception {    
        return "/adminlogin";
    }

	@RequestMapping(value="/adminlogin",method=RequestMethod.POST)
	public String submit(@Validated @ModelAttribute("AdminLoginCommand")AdminLoginCommand adminloginCommand, 
            HttpSession session, HttpServletResponse response, Errors errors) throws Exception {
		new AdminLoginCommandValidator().validate(adminloginCommand, errors);
		
		if(errors.hasErrors()) {
			System.out.println("실패");
			return "/adminlogin";
		}
		
		try {
			System.out.println(adminloginCommand.getAdm_id());
			System.out.println(adminloginCommand.getAdm_pass());
			
			
			
			AdminAuthInfo adminauthInfo = adminService.authenticate(
					adminloginCommand.getAdm_id(), 
					adminloginCommand.getAdm_pass());
			
			//세션에 adminauthInfo저장
			session.setAttribute("adminauthInfo", adminauthInfo);
			
			
			
			
			//return "loginSuccess";
			//로그인 성공 시 관리자 페이지
			System.out.println("성공");
			return "/loginSuccess";
			
			
			} catch (IdPasswordNotMatchingException e) {
				errors.reject("IdPasswordMatching");
				System.out.println("오류");
				return "/adminlogin";
			}
	}
	

}
