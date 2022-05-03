package org.exam.www.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.exam.www.exception.AuthstatusException;
import org.exam.www.exception.IdPasswordNotMatchingException;
import org.exam.www.model.AdminVO;
import org.exam.www.model.CommandLogin;
import org.exam.www.model.CommandLogin;
import org.exam.www.model.MemberVO;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	//일반 로그인
	@RequestMapping(value="/loginForm", method=RequestMethod.GET)
    public String loginform(CommandLogin loginCommand, HttpServletRequest request,
    		@CookieValue(value="REMEMBER", required=false) Cookie rememberCookie) throws Exception {    
		
		//세션 유지 중 로그인 창 요청시 메인 페이지로 이동 
		HttpSession session = request.getSession(false);
		if(session != null) {
			Object authInfo = session.getAttribute("authInfo");
			if(authInfo != null) {
				return "/main";
			}	
		}
		if(rememberCookie!=null) {
            loginCommand.setMem_id(rememberCookie.getValue());
            loginCommand.setRememberId(true);
        }
        return "/loginForm";
    }

	@RequestMapping(value="/loginForm",method=RequestMethod.POST)
	public String loginsubmit(@Validated CommandLogin loginCommand, Model model,
            HttpSession session, HttpServletResponse response, Errors errors) throws Exception {
		new LoginCommandValidator().validate(loginCommand, errors);
		
		if(errors.hasErrors()) {
			System.out.println("오류");
			return "/loginForm";
		}
		
		try {
			System.out.println(loginCommand.getMem_id());
			System.out.println(loginCommand.getMem_pass());
			
			
			CommandLogin authInfo = loginService.authenticate(
					loginCommand.getMem_id(), 
					loginCommand.getMem_pass(),
					loginCommand.getAuthstatus());
				
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
			System.out.println("성공");
			return "/loginpage";
			
			} catch (IdPasswordNotMatchingException e) {
				errors.rejectValue("mem_pass", "IdPasswordNotMatching");
				System.out.println("실패");
				return "/error";
			} catch (AuthstatusException e) {
				
				return "/errorAuthstauts";
			}
	}
	
	//logout
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate(); //세션 제거
		return "/main";
	}
	
	//findId
	@RequestMapping(value="/findIdForm", method=RequestMethod.GET)
	public String findIdView() {
		return "/findIdForm";
	}
	
	@RequestMapping(value="/findId", method=RequestMethod.POST)
	public String findid(MemberVO member, Model model, String mem_email) throws Exception {
		
		model.addAttribute("mem_id", loginService.findById(mem_email));
		return "/findId";
		
	}
	
//	@RequestMapping(value="/findId", method=RequestMethod.POST)
//	public String findid(@RequestParam("mem_email") String mem_email, Model model) throws Exception{
//		model.addAttribute("mem_id", loginService.findById(mem_email));
//		return "/findid";
//	}
	
	

	
}
