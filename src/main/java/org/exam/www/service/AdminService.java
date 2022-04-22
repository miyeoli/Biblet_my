package org.exam.www.service;



//관리자 로그인
public interface AdminService {
	 
	public AdminAuthInfo authenticate(String adm_id, String adm_pass) throws Exception;
	
	
	//public void logout(HttpSession session);
	

}
