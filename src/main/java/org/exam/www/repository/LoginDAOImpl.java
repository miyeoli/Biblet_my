package org.exam.www.repository;


import java.util.HashMap;
import java.util.Map;

import org.exam.www.model.AdminVO;
import org.exam.www.model.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	
	//회원 조회
	@Override
	public MemberVO selectByEmail(String mem_email) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("selectByEmail", mem_email);
	}
	
	//일반회원 로그인
	@Override
	public MemberVO selectById(String mem_id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("selectById", mem_id);
	}

	//관리자 로그인
	@Override
	public AdminVO selectByAdminId(String adm_id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("selectByAdminId", adm_id);
	}

	//아이디 찾기
	@Override
	public String findById(String mem_email) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("findById", mem_email);
	}

	//비밀번호 재설정
	@Override
	public int findByPw(String mem_pass, String mem_email) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mem_pass", mem_pass);
		map.put("mem_email", mem_email);
		return sqlSessionTemplate.update("findByPw", map);
	}

	
	

	


	

}
