package org.exam.www.repository;

import org.exam.www.model.MemberVO;

public interface MemberDAO {

	//id 확인
	public MemberVO selectById(String mem_id);

	//public String loginCheck(MemberVO user);



}
