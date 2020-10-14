package com.biz.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	
	@RequestMapping(value = "/join",method = RequestMethod.GET)
	public String join() {
		// return "user/join";
		return "user/join";
	}
	
	@RequestMapping(value = "/mypage",method = RequestMethod.GET)
	public String mypage() {
		
		// internalview 를 사용한 rendering
		// return "users/mypage" >> internalview를 사용한 rendering
		// return "mypage" >> tiles의 mypage definition을 찾아 rendering
		return "user/mypage"; // >> tiles 의 user/* 찾고,
							  // 		* 대신 mypage문자열을 전달하여 rendering
		
		// 1. tiles-layout.xml에서 user/mypage 설정값을 찾아보기
		// 2. tiles-layout.xml에서 user/* 설정값을 찾아보기
		//		1 또는 2번에서 해당 설정을 찾게 되면 template로 설정된 layout.jsp을 열고
		//		attribute로 설정된 jsp 파일들을 loading 하여 layout.jsp에 설정된 대로
		//		layout을 만들고, html로 rendering 한 후 response
		
		// 3. 
	}
}
