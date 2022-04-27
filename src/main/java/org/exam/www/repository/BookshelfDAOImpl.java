package org.exam.www.repository;


import java.util.List;

import org.exam.www.model.BookshelfVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookshelfDAOImpl implements BookshelfDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	//인기 도서 리스트
	@Override
	public List<BookshelfVO> starlist() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("starlist");
	}
	
	
	

	
	



	

}
