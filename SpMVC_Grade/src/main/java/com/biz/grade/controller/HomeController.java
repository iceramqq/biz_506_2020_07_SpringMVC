package com.biz.grade.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.grade.model.GradeVO;
import com.biz.grade.service.GradeService;

@Controller
public class HomeController {
	
	@Autowired
	@Qualifier("gradeServiceV1")
	private GradeService gradeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		List<GradeVO> gradeList = gradeService.selectAll();
		model.addAttribute("gradeList",gradeList);
		return "home";
	}
	
	@RequestMapping(value="/input",method=RequestMethod.GET)
	public String write() {
		return "write";
	}
	
	@RequestMapping(value="/input",method=RequestMethod.POST)
	// public String write(String from_email,String to_email,String s_subject,Model model) {
	public String write(@ModelAttribute GradeVO gradeVO) {
		
		gradeService.insert(gradeVO);
		
		return "redirect:/";
	}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(String id,Model model) {
		
		GradeVO gradeVO = gradeService.findById(id);
		model.addAttribute("gradeVO",gradeVO);
		return "write";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(GradeVO gradeVO) {

		gradeService.update(gradeVO);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(String id) {
		
		gradeService.delete(id);
		
		return "redirect:/";
	
	}
	
}
