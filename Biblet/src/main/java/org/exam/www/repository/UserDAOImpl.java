package org.exam.www.repository;

import java.util.List;

import org.exam.www.model.UserVO;
import org.mybatis.spring.SqlSessionTemplate;

public class UserDAOImpl implements UserDAO{
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public UserDAOImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public String loginCheck(UserVO user) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("userDAO.loginCheck", user);
	}
	

}
