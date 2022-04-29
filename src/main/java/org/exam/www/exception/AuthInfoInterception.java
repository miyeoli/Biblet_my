package org.exam.www.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInfoInterception extends HandlerInterceptorAdapter{
	
	@Override
	   public boolean preHandle(HttpServletRequest request,
	         HttpServletResponse response, Object handler) throws Exception {

	      HttpSession session = request.getSession();
	      
	      if(session.getAttribute("AuthInfo") != null) {
	            response.sendRedirect("/main");
	            
	            return false;
	        }
	        return true;
	   }


}
