package org.exam.www.controller;

import java.util.List;

//import org.exam.www.model.BookshelfVO;
//import org.exam.www.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	/*
	private MainService mainService;
	
	public void setmainService(MainService mainService) {
		this.mainService = mainService;
	}
	*/
	
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public void mainform() {
		System.out.println("메인 페이지");
	}
	
	//회원가입 페이지 이동
	//로그인 페이지 이동
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void login() {
		System.out.println("로그인 페이지");
	}
	//관리자 계정으로 로그인 시 관리자 페이지 이동
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public void admin() {
		System.out.println("관리자 페이지");
	}
	
	/*
	 
	//마이페이지
	//검색
	//코멘드리스트(평가 페이지)
	@RequestMapping(value="/commentbook", method= RequestMethod.GET)
	public void comment() {
		System.out.println("도서 코멘트 리스트 페이지");
	}
	
	//인기 도서 목록(평가 수 많은 top3 도서 이미지, 제목) 도서 클릭 시 상세 페이지로 이동
	@RequestMapping(value="/starlist")
	@ResponseBody
	public String starlist(Model model) {
		System.out.println("인기 도서");
		List<BookshelfVO> starlist = mainService.starlist();
		model.addAttribute("starlist",starlist);
		return 
		
	}
	
	*/
	
	

}
