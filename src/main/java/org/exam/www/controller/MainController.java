package org.exam.www.controller;

import java.util.List;

import org.exam.www.model.AppraisalVO;
import org.exam.www.model.BookshelfVO;
import org.exam.www.model.Commentlist;
import org.exam.www.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;
	
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
	



	
	
	

}
