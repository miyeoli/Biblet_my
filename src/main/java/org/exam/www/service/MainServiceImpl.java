package org.exam.www.service;

import java.util.List;

import org.exam.www.model.BookshelfVO;
<<<<<<< HEAD
import org.exam.www.model.Commentlist;
import org.exam.www.repository.MainDAO;
=======
<<<<<<< HEAD
=======
import org.exam.www.model.Commentlist;
import org.exam.www.repository.MainDAO;
>>>>>>> 37b08e76a3ade3cc066d049aafe0b085fb59deff
>>>>>>> d3da63c6bfb6165d8cf7f80c192e29c21d2e6b89
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService{
	
<<<<<<< HEAD

	@Autowired
	private MainDAO mainDAO;

=======
<<<<<<< HEAD
=======
	@Autowired
	private MainDAO mainDAO;

>>>>>>> d3da63c6bfb6165d8cf7f80c192e29c21d2e6b89
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

<<<<<<< HEAD

=======
>>>>>>> 37b08e76a3ade3cc066d049aafe0b085fb59deff
>>>>>>> d3da63c6bfb6165d8cf7f80c192e29c21d2e6b89
}
