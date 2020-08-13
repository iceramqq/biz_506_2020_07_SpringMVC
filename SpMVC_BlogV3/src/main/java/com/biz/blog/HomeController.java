package com.biz.blog;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.blog.service.BlogService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	//a href="constext/input"으로 request를 했을때
	//a href="http://localhost/blog/input"으로 request를 했을때
	//처리할 method를 지정
	@RequestMapping(value = "/input",method = RequestMethod.GET)
	public String input() {
		
		// /WEB-INF/views/write.jap 파일을 response 하여라
		return "write";
	}
	
	/*
	 * form에서 input box에 입력한 내용은
	 * http protocol에 의해 네트워크를 건너서 server로 전송이 되고
	 * 그 데이터는 
	 */
	@RequestMapping(value = "/writer",method=RequestMethod.POST)
	public String writer(String title, String content, Model model) {
		System.out.println("나는 POST Type writer method !!");
		System.out.println("제목 : "+title);
		System.out.println("내용 : "+content);
		
		model.addAttribute("TITLE", title);
		model.addAttribute("CONTENT", content);
		//controller의 함수에서 을 수행한면
		//에서 지정한 값을 문자열로 자동인식한다
		return "view";
	}
	
	@RequestMapping(value = "/writer",method=RequestMethod.GET)
	public String writer() {
		System.out.println("나는 GET Type writer method !!");
		return null;
	}
	

}