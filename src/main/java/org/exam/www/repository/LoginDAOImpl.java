package org.exam.www.repository;


import org.exam.www.model.AdminVO;
import org.exam.www.model.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

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

	


	

}
