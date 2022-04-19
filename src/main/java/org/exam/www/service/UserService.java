package org.exam.www.service;

import org.exam.www.model.MemberVO;

//아이디와 비번 일치 시 AuthInfo 객체 생성
public interface UserService {

	
	//public AuthInfo authenticate(String mem_id, String mem_pass);


	public AuthInfo authenticate(String mem_id, String mem_pass) throws Exception;
		
	//findbyid	 
	public MemberVO findById(MemberVO member);
	

}
