package org.exam.www.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.exam.www.model.AdminVO;
import org.exam.www.service.AdminAuthInfo;
import org.exam.www.service.AdminService;
import org.exam.www.util.IdPasswordNotMatchingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminLoginController {
	
	private AdminService adminService;
	
	@Autowired
	public void setadminService(AdminService adminService) {
		this.adminService=adminService;
	}
	
	//login
	@RequestMapping(value="/adminlogin", method=RequestMethod.GET)
    public String form(AdminLoginCommand adminloginCommand) throws Exception {    
        return "/adminlogin";
    }

	@RequestMapping(value="/adminlogin",method=RequestMethod.POST)
	public String submit(@Validated AdminLoginCommand adminloginCommand, AdminVO admin,
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
			
			System.out.println(adminauthInfo.getAdm_id());
			
			
			session.setAttribute("adminauthInfo", adminauthInfo);
			
			System.out.println(adminloginCommand.getAdm_id());
			System.out.println(adminloginCommand.getAdm_pass());
			
			
			//return "loginSuccess";
			//로그인 성공 시 메인 페이지
			System.out.println("성공");
			return "/loginSuccess";
			
			
			} catch (IdPasswordNotMatchingException e) {
				errors.reject("IdPasswordMatching");
				System.out.println("오류");
				return "/adminlogin";
			}
		
		//에러 메세지
		//로그인 화면
		
		//아이디 비번 미 입력 시 입력해 주세요
		//아이디 비번 틀렸을 때 다시 입력해 주세요
		//아이디 없을 때 회원 정보가 없습니다.
		//관리자 로그인 시 관리자 페이지 이동
		
		//아이디 비번 찾기
		

	}
	

}
