package com.biz.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.shop.model.DeptVO;
import com.biz.shop.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/dept")
@Controller
public class DeptController {
	
	@Autowired
	@Qualifier("dServiceV1")
	private DeptService dService;
	
	@RequestMapping(value = "/",method=RequestMethod.GET)
	public String deptHome(Model model) {
		
		List<DeptVO> dList = dService.selectAll();
		
		model.addAttribute("DEPT_LIST", dList);
		model.addAttribute("BODY","DEPT_HOME");
		
		return "home";
		
	}
	
	@RequestMapping(value = "/insert",method=RequestMethod.GET)
	public String insert(Model model) {
		
		model.addAttribute("BODY","DEPT_WRITE");
		return "home";
	}
	
	@RequestMapping(value = "/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute DeptVO dVO) {
		
		log.debug("거래처정보 입력 : {}", dVO.toString());
		
		int ret = dService.insert(dVO);
		
		return "redirect:/dept/";
	}
	
}
