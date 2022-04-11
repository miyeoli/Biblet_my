package org.exam.www.service;

import javax.servlet.http.HttpSession;

import org.exam.www.model.UserVO;

public interface UserService {
	
	public String loginCheck(UserVO user, HttpSession session);


}
