package org.exam.www.repository;

import org.exam.www.model.AdminVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAOImpl implements AdminDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public AdminVO selectByAdminId(String adm_id) {
		// TODO Auto-generated method stub
		System.out.println("여기는 DAOImpl "+adm_id);
		return sqlSessionTemplate.selectOne("selectByAdminId", adm_id);
	}

	
}
