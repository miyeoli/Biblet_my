package org.exam.www.controller;

import javax.servlet.http.HttpSession;

import org.exam.www.model.UserVO;
import org.exam.www.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	private UserService userService;
	
	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		System.out.println("로그인");
		return "loginForm";
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute UserVO user, HttpSession session) {
		String mem_name = userService.loginCheck(user, session);
		ModelAndView mav = new ModelAndView();
		
		if (mem_name != null) { // 로그인 성공 시
			System.out.println("성공");
			mav.setViewName("/loginSuccess"); // 뷰의 이름
		} else { // 로그인 실패 시
			System.out.println("실패");
			mav.setViewName("/loginForm"); 		
		
		} 
		//쿠키 세션
				//예외 처리 
				//회원 정보가 없을 때
				//아이디와 비번이 일치하지 않을 때
				//이메일 인증 authstatus = 1 로그인 authstatus = 1 X 이메일 인증 안됨 에러 메세지
				return mav;			

	}
	
	
	

	
}

	
