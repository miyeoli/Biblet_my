package org.exam.www.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.exam.www.service.AuthInfo;
import org.exam.www.service.UserService;
import org.exam.www.util.IdPasswordMatchingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	

	@RequestMapping(method=RequestMethod.GET)
    public String form(LoginCommand loginCommand,
                    @CookieValue(value="REMEMBER", required=false) Cookie rememberCookie) throws Exception {    
		
		if(rememberCookie!=null) {
            loginCommand.setMem_id(rememberCookie.getValue());
            loginCommand.setRememberId(true);
        }
        
        return "loginForm";
    }

	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@Validated LoginCommand loginCommand,
            HttpSession session, HttpServletResponse response, Errors errors) throws Exception {
		new LoginCommandValidator().validate(loginCommand, errors);

		if(errors.hasErrors()) {
			return "loginForm";
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
			
			return "loginSuccess";
			
			} catch (IdPasswordMatchingException e) {
			errors.rejectValue("pw", "notMatch", "아이디와 비밀번호가 맞지않습니다.");
			return "loginForm";
			}

		}
	
	

	
}
