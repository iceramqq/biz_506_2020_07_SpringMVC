package com.biz.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.bbs.model.BbsVO;
import com.biz.bbs.service.BbsService;

@RestController
@RequestMapping(value = "/api")
public class BbsAPIController {

	@Autowired
	private BbsService bService;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public List<BbsVO> list(){
		
		List<BbsVO> bbsList = bService.selectAll();
		return bbsList;
	}
	
	@RequestMapping(value = "/item/{id}",method = RequestMethod.GET)
	public BbsVO item(String id){
		
		BbsVO bbsVO = bService.findById(Long.valueOf(id));
		return bbsVO;
	}
	
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	public String insert(@ModelAttribute BbsVO bbsVO) {
		
		bService.insert(bbsVO);
		return "OK";
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String update(@ModelAttribute BbsVO bbsVO) {
		
		bService.update(bbsVO);
		return "OK";
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
	public String delete(String id) {
		
		bService.delete(Long.valueOf(id));
		return "OK";
	}
}
