package com.biz.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.shop.model.ProductVO;
import com.biz.shop.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/product")
@Controller
public class ProductController {
	
	@Autowired
	@Qualifier("proServiceV1")
	private ProductService proService;
	
	//
	//
	@RequestMapping(value = "/",method=RequestMethod.GET)
	public String proHome(Model model) {
		
		//
		List<ProductVO> proList = proService.selectAll();
		
		//
		model.addAttribute("PRO_LIST",proList);
		model.addAttribute("BODY","PRO_HOME");
		return "home";
	}
	// insert get method : 상품정보 추가 를 클릭했을때
	//
	//
	@RequestMapping(value = "/insert",method=RequestMethod.GET)
	public String insert(Model model) {
		
		//
		model.addAttribute("BODY","PRO_WRITE");
		return "home";
	}
	
	//
	//
	@RequestMapping(value = "/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute ProductVO proVO) {
		
		log.debug("상품정보 입력 : {}", proVO.toString());
		
		int ret = proService.insert(proVO);
		
		return "redirect:/product/";
	}
}
