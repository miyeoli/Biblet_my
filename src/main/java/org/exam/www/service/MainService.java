package org.exam.www.service;

import java.util.List;

import org.exam.www.model.AppraisalVO;
import org.exam.www.model.BookshelfVO;

public interface MainService {

	//인기 도서 리스트
	//bookshelf에서 ibsn 가져오기
	public List<BookshelfVO> starlist();
		
		
	//최근 코멘트
	public List<AppraisalVO> listcomment();
}
