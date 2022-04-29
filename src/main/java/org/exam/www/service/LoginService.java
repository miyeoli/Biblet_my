package org.exam.www.service;

import org.exam.www.model.CommandAdminAuthInfo;
import org.exam.www.model.CommandLogin;

//로그인 서비스
public interface LoginService {
	 
	
	//일반 회원 로그인
	public CommandLogin authenticate(String mem_id, String mem_pass, int authstatus) throws Exception;
	
	//관리자 로그인
	public CommandAdminAuthInfo adminauthenticate(String adm_id, String adm_pass) throws Exception;
	
	

}
