package com.biz.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.book.model.BookVO;
import com.biz.book.service.NaverService;
import com.biz.book.service.NaverServiceImplV1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/naver")
public class NaverController {

	@Autowired
	@Qualifier("naverServiceV1")
	private NaverService nServiceV1;
	
	@Autowired
	@Qualifier("naverServiceV2_xml")
	private NaverService nServiceV2;
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String search(String search_text) {
		log.debug("search");
		return "naver/naver-search-list";
	}
	
	/*
	 * 의 매개변수를 재정의 하는 용도
	 * 만약 에서 보내ㅡㄴㄴ 변수 이름과 에서 사용하는 변수 이름을 
	 * 다르게 하고 싶으면
	 * @RequestParam(name="변수") string 내이름
	 * 
	 * 에서 해당 변수값을 빼먹고 정송을 했을때 오류룰 최소화 하기 위해서
	 * @RequestParam(name="내이름",
			required = false,
			defaultValue = "홍길동"
	 * 
	 * 
	 * 문자열을 내이름 변수에 할당 한다.
	 */
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String search(@RequestParam(name="category",
			required = false,
			defaultValue = "BOOK") String category,
			
			@RequestParam(name="search_text") String search_text,Model model) {

		log.debug(search_text);
		log.debug(category);
		
		String queryURL 
			= nServiceV2.queryURL(category,search_text.trim());
		
		//String jsonString = naverService.getNaverSearch(queryURL);
		//vo
		//List<BookVO> bookList = naverService.getNaverList(jsonString);
		
		List<BookVO> bookList = nServiceV2.getNaverList(queryURL);
		
		log.debug(bookList.toString());
		model.addAttribute("NAVERS",bookList);
		return "naver/naver-search-list";
	
	}
	
	@ResponseBody
	@RequestMapping(value="/api",
			method=RequestMethod.POST,
			produces = "application/xml;charset=utf8")
	public String naver(String book_name) {
		
		String queryURL = nServiceV1.queryURL("BOOK",book_name);
		String resString = nServiceV1.getNaverSearch(queryURL);
		return resString;
		
		//List<BookVO> bookList = naverService.getNaverList(resString);
		//return bookList;
	}
	
	// .../
	@ResponseBody
	@RequestMapping(value = "/query",method = RequestMethod.GET)
	public String query(int num1,
			@RequestParam(name="num2",
			required = false,
			defaultValue = "500") int num2) {
		return (num1+num2) + "";
	}
}
