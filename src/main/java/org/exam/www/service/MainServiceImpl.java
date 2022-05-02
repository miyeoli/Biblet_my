package org.exam.www.service;

import java.util.List;

import org.exam.www.model.BookshelfVO;
import org.exam.www.model.Commentlist;
import org.exam.www.repository.MainDAO;
import org.exam.www.model.Commentlist;
import org.exam.www.repository.MainDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService{
	


	@Autowired
	private MainDAO mainDAO;
	//인기 도서 리스트
	@Override
	public List<BookshelfVO> starlist() {
		// TODO Auto-generated method stub
		return mainDAO.starlist();
	}

	//최근 코멘트
	@Override
	public List<Commentlist> commentlist() {
		// TODO Auto-generated method stub
		return mainDAO.commentlist();
	}


}
