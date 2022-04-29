package org.exam.www.repository;

import java.util.List;

import org.exam.www.model.BookshelfVO;
import org.exam.www.model.Commentlist;

public interface MainDAO {
	
	
	//인기 도서 리스트
	public List<BookshelfVO> starlist();
	
	//코멘트 리스트
	public List<Commentlist> commentlist();

	
	

}
