package org.exam.www.repository;

import org.exam.www.model.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public MemberVO selectById(String mem_id) {
		return sqlSessionTemplate.selectOne("selectById", mem_id);
	}


	/*
	@Override
	public String loginCheck(MemberVO user) {
		// TODO Auto-generated method stub
		return null;
	}
	*/


	

}
