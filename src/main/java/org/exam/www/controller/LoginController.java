package org.exam.www.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.exam.www.model.MemberVO;
import org.exam.www.repository.MemberDAO;
import org.exam.www.service.AuthInfo;
import org.exam.www.service.UserService;
import org.exam.www.util.IdPasswordMatchingException;
import org.exam.www.util.IdPasswordNotMatchingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	private UserService userService;
	
	@Autowired
	public void setuserService(UserService userService) {
		this.userService = userService;
	}
	

	//login
	@RequestMapping(value="/loginForm", method=RequestMethod.GET)
    public String form(LoginCommand loginCommand,
                    @CookieValue(value="REMEMBER", required=false) Cookie rememberCookie) throws Exception {    
		
		if(rememberCookie!=null) {
            loginCommand.setMem_id(rememberCookie.getValue());
            loginCommand.setRememberId(true);
        }
        
        return "/loginForm";
    }

	@RequestMapping(value="/loginForm",method=RequestMethod.POST)
	public String submit(@Validated LoginCommand loginCommand, MemberVO member, Model model,
            HttpSession session, HttpServletResponse response, Errors errors) throws Exception {
		new LoginCommandValidator().validate(loginCommand, errors);
		
		if(errors.hasErrors()) {
			return "/loginForm";
		}

		try {
			System.out.println(loginCommand.getMem_id());
			System.out.println(loginCommand.getMem_pass());
			
			
			
			AuthInfo authInfo = userService.authenticate(
					loginCommand.getMem_id(), 
					loginCommand.getMem_pass());
			
			session.setAttribute("authInfo", authInfo);
			
			Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getMem_id());
			rememberCookie.setPath("/");
			if(loginCommand.isRememberId()) {
			rememberCookie.setMaxAge(60*60*24*7);
			} else {
			rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);
			
			//return "loginSuccess";
			//로그인 성공 시 메인 페이지
			return "/loginpage";
			
			
			} catch (IdPasswordNotMatchingException e) {
				errors.reject("IdPasswordMatching");
				return "/loginForm";
			}
		
		//에러 메세지
		//로그인 화면
		
		//아이디 비번 미 입력 시 입력해 주세요
		//아이디 비번 틀렸을 때 다시 입력해 주세요
		//아이디 없을 때 회원 정보가 없습니다.

		
		//아이디 비번 찾기
		//아이디 찾기 - 이메일 입력 아이디 확인
		//비밀번호 찾기 - 이메일 인증 비밀번호....... .재설정? 확인
		

	}
	
	/*
	
	//findId
	//이메일로 아이디 찾기
	
	// 아이디 찾기 페이지 이동
		@RequestMapping(value="/findIdForm", method=RequestMethod.GET)
		public String findIdView() {
			return "/findIdForm";
		}
		
	    // 아이디 찾기 실행
		@RequestMapping(value="/findIdForm", method=RequestMethod.POST)
		public String findIdAction(MemberVO member, Model model) {
			MemberVO mem = userService.findById(member);
			
			if(member == null) { 
				model.addAttribute("check", 1);
			} else { 
				model.addAttribute("check", 0);
				model.addAttribute("id", member.getMem_id());
			}
			System.out.println(member.getMem_id());
			return "/findIdForm";
		}
		
		*/
	
	
	/*
	@RequestMapping(value="/findIdForm", method=RequestMethod.GET)
	public String findIdView() {
		return "/findIdForm";
		
	}
	@RequestMapping(value="/findIdForm", method=RequestMethod.POST)
	public String findId(MemberVO member, Model model) {
		
		if(memberDAO.findId(member.getMem_email()) == 0) {
			model.addAttribute("msg","이메일을 확인해주세요");
		}
		
		return "/findIdForm";
		
	}
	*/
	
	//findPass
	
	
	//logout
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate(); //세션 제거
		return "redirect:/main";
	}
	
	

	
}
