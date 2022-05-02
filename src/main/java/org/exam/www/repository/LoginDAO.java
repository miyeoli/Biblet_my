package org.exam.www.repository;

<<<<<<< HEAD
=======


>>>>>>> d3da63c6bfb6165d8cf7f80c192e29c21d2e6b89
import org.exam.www.model.AdminVO;
import org.exam.www.model.MemberVO;

public interface LoginDAO {

	//일반 회원 로그인
	public MemberVO selectById(String mem_id);
	
	//관리자 로그인
	public AdminVO selectByAdminId(String adm_id);

	
	



}
