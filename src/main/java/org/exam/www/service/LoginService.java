package org.exam.www.service;

<<<<<<< HEAD
import org.exam.www.model.CommandAdminLogin;
=======
import org.exam.www.model.CommandAdminAuthInfo;
>>>>>>> d3da63c6bfb6165d8cf7f80c192e29c21d2e6b89
import org.exam.www.model.CommandLogin;

//로그인 서비스
public interface LoginService {
	 
	
	//일반 회원 로그인
	public CommandLogin authenticate(String mem_id, String mem_pass, int authstatus) throws Exception;
	
	//관리자 로그인
<<<<<<< HEAD
	public CommandAdminLogin adminauthenticate(String adm_id, String adm_pass, int adm_authstatus) throws Exception;
=======
	public CommandAdminAuthInfo adminauthenticate(String adm_id, String adm_pass) throws Exception;
>>>>>>> d3da63c6bfb6165d8cf7f80c192e29c21d2e6b89
	
	

}
