package org.exam.www.repository;



import org.exam.www.model.AdminVO;
import org.exam.www.model.MemberVO;

public interface LoginDAO {

	//일반 회원 로그인
	public MemberVO selectById(String mem_id);
	
	//관리자 로그인
	public AdminVO selectByAdminId(String adm_id);

	
	



}
