package org.exam.www.service;

import java.util.List;

import org.exam.www.model.AppraisalVO;
import org.exam.www.model.BookshelfVO;
import org.exam.www.repository.AppraisalDAO;
import org.exam.www.repository.BookshelfDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService{
	
	@Autowired
	private BookshelfDAO bookshelfDAO;
	
	@Autowired
	private AppraisalDAO appraisalDAO;

	@Override
	public List<BookshelfVO> starlist() {
		// TODO Auto-generated method stub
		return bookshelfDAO.starlist();
	}

	@Override
	public List<AppraisalVO> listcomment() {
		// TODO Auto-generated method stub
		return appraisalDAO.listcomment();
	}

}
