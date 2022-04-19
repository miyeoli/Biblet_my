package org.exam.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
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
	
	//마이페이지
	//검색
	//코멘드(평가 페이지)
	//인기 도서 목록(평가 수 많은 top3 도서 이미지, 제목)

}
