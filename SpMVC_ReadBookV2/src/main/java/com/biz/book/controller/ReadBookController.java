package com.biz.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.book.mapper.ReadBookDao;
import com.biz.book.model.ReadBookVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(value = "/read")
public class ReadBookController {

	/*
	 * 
	 * @autowried를 주로 많이 하는데
	 * @autowried로 묶을때 취근에 권장사항이 모든 변수를 scope를 private으로 선언하라고 한다
	 * 
	 * @autowried가 내부에서 메모리 누수 현상이 발견되어서
	 * 가급적이면 privte final로 선언하고 
	 * 생성자를 만들어서 각 객체 변수를 초기화하도록 한다
	 * final로 선언된 모든 변수는 반드시 생성자에서 외부로 주입받거나
	 * 자체적으로 변수를 초기화 하는 콛드를 만들어야 한다
	 * 
	 * 
	 * lombok에 있는 @RequiredArgsConstructor를 사용하여 생성자 코드를 
	 * 자동으로 만들도록 해준다
	 */
	private final ReadBookDao rbookDao;
	
	@RequestMapping(value = "/write",method = RequestMethod.POST)
	public String write(@ModelAttribute ReadBookVO rbookVO,Model model) {
		
		log.debug("독서록정보 : " + rbookVO.toString());
		
		int ret = rbookDao.insert(rbookVO);
		
		//model.addAttribute("BDDY","BOOK-DETAIL");
		
		return "redirect:/books/detail/" + rbookVO.getR_book_seq();
	}
}
