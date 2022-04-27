package org.exam.www.repository;

import java.util.List;

import org.exam.www.model.AppraisalVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppraisalDAOImpl implements AppraisalDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<AppraisalVO> listcomment() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("listcomment");
	}

	


	



	

}
