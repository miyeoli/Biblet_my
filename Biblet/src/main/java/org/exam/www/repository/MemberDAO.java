package org.exam.www.repository;



import org.exam.www.model.MemberVO;

public interface MemberDAO {

	//id 확인
	public MemberVO selectById(String mem_id);
	
	//이메일로 id 찾기
	public MemberVO findById(MemberVO member);

	//public String loginCheck(MemberVO user);



}
