package com.biz.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.biz.book.mapper.BookDao;
import com.biz.book.model.BookVO;
import com.biz.book.service.NaverService;

import lombok.extern.slf4j.Slf4j;

/*
 * 객체를, 문자열 등을 직접 
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class BookApiController {
	
	@Autowired
	@Qualifier(value="naverServiceV2")
	private NaverService<BookVO> nService;
	
	@Autowired
	private BookDao bookDao;
	
	/*
	 * produces
	 * 클라이언트에게 데이터를 보내는 형식을 지정하는 속성
	 * 기본값이 application/json형태인데 만약
	 * 클라이언트에서 json데이터를 제대로 수신하지 못하면
	 * 강제로 값을 지정해 주자
	 */
	@RequestMapping(value = "/isbn",
			method = RequestMethod.POST,
			produces = "application/json;charset=utf8")
	public BookVO naverSearch(String search_text) {
		String queryURL = nService.queryURL("BOOK", search_text);
		
		/* 
		 * 
		 * 
		 * 
		 * isbn으로 조회를 했을때는 다른 데이터가 있더라도 무시하고
		 * 첫번째 데이터만 
		 */
		BookVO bookVO = nService.getNaverList(queryURL).get(0);
		log.debug("도서정보 : "+bookVO.toString());
		return bookVO;
	}
	
	@RequestMapping(value = "/detail/{book_seq}",method = RequestMethod.GET,
			produces = "application/json;charset=utf8")
	public BookVO detail(@PathVariable("book_seq") String id, Model model) {
		
		log.debug("PATH : {}",id);
		long seq = Long.valueOf(id);
		BookVO bookVO = bookDao.findById(seq);
		// log.debug(bookVO.toString());
		
		return bookVO;
	}
}
