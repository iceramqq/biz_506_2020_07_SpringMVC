package com.biz.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.blog.model.BlogVO;
import com.biz.blog.service.BlogService;

@RequestMapping(value = "/blog")
@Controller
public class BlogController {
	
	@Autowired
	private BlogService bService;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public String list() {
		
		System.out.println("여기는 블로그 리스트 보기!!!");
		return "home";
	}
	
	@RequestMapping(value = "/input",method = RequestMethod.GET)
	public String input() {
		
		return "write";
	}
	
	
	@RequestMapping(value = "/writer",method=RequestMethod.POST)
	public String writer(@ModelAttribute BlogVO blogVO,Model model) {
		
		System.out.println("USER : "+ blogVO.getUser());
		System.out.println("TITLE : "+ blogVO.getTitle());
		System.out.println("CONTENT : "+ blogVO.getContent());
		
		bService.insert(blogVO);
		
		model.addAttribute("TITLE",blogVO.getTitle());
		model.addAttribute("CONTENT",blogVO.getContent());
		model.addAttribute("USER",blogVO.getUser());
		return "view";
	}
	
	@RequestMapping(value = "/writer1",method=RequestMethod.GET)
	public String writer1() {
		
		return null;
	}
	
}
