package org.exam.www.service;

import javax.servlet.http.HttpSession;

import org.exam.www.model.UserVO;
import org.exam.www.repository.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public String loginCheck(UserVO user, HttpSession session) {
		String mem_name = userDAO.loginCheck(user);
		 if (mem_name != null) { // 세션 변수 저장
		  session.setAttribute("mem_id", user.getMem_id());
		  session.setAttribute("mem_name", mem_name);
		}
		 return mem_name; 
		
	}


	

}
