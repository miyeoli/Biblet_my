package org.exam.www.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.exam.www.exception.AuthstatusException;
import org.exam.www.exception.IdPasswordNotMatchingException;
import org.exam.www.exception.IdPasswordNotMatchingException;
import org.exam.www.model.CommandAdminLogin;
import org.exam.www.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class AdminLoginController {
	

	@Autowired
	private LoginService loginService;

	
//	@Autowired
//	public void setadminService(LoginService loginService) {
//		this.loginService = loginService;
//	}
	
	//관리자 로그인
	@RequestMapping(value="/adminlogin", method=RequestMethod.GET)
    public String adminform(CommandAdminLogin adminloginCommand, HttpServletRequest request,
    		@CookieValue(value="REMEMBER", required=false) Cookie rememberCookie) throws Exception {    
    
      //세션 유지 중 로그인 창 요청시 메인 페이지로 이동 
		HttpSession session = request.getSession(false);
		if(session != null) {
			Object adminauthInfo = session.getAttribute("adminauthInfo");
			if(adminauthInfo != null) {
				return "/main";
			}
			
		}
		
		if(rememberCookie!=null) {
		    adminloginCommand.setAdm_id(rememberCookie.getValue());
		    adminloginCommand.setRememberAdmId(true);
		}
		
		return "/adminlogin";
      		
	
	}

	@RequestMapping(value="/adminlogin",method=RequestMethod.POST)
	public String adminsubmit(@Validated CommandAdminLogin adminloginCommand, 
            HttpSession session, HttpServletResponse response, Errors errors) throws Exception {

		new AdminLoginCommandValidator().validate(adminloginCommand, errors);
		
		if(errors.hasErrors()) {
			System.out.println("실패");
			return "/adminlogin";
		}
		
		try {
			System.out.println(adminloginCommand.getAdm_id());
			System.out.println(adminloginCommand.getAdm_pass());


			CommandAdminLogin adminauthInfo = loginService.adminauthenticate(

					adminloginCommand.getAdm_id(), 
					adminloginCommand.getAdm_pass(),
					adminloginCommand.getAdm_authstatus());
			
			//세션에 adminauthInfo저장
			session.setAttribute("adminauthInfo", adminauthInfo);
			
			Cookie rememberCookie = new Cookie("REMEMBER", adminloginCommand.getAdm_id());
			rememberCookie.setPath("/");
			if(adminloginCommand.isRememberAdmId()) {
			rememberCookie.setMaxAge(60*60*24*7);
			} else {
			rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);
			

			System.out.println("성공");
			//성공시 관리자 페이지로 이동
			return "/loginSuccess";

			} catch (IdPasswordNotMatchingException e) {
				errors.rejectValue("adm_pass", "IdPasswordNotMatching");
				System.out.println("실패");
				return "/error";
			} catch (AuthstatusException e) {
				
				return "/errorAuthstauts";
			}
	}
	
//	//logout
//	@RequestMapping(value="/logout", method=RequestMethod.GET)
//	public String logout(HttpSession session) {
//		session.invalidate(); //세션 제거
//		return "redirect:/main";
//	}
		
	

}
