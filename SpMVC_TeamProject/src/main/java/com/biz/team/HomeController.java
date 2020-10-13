package com.biz.team;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String home(Model model) {
		
		return "home";
	}
	
	@RequestMapping(value = "/page1",method = RequestMethod.GET)
	public String page1(Model model) {
		
		model.addAttribute("BODY", "PAGE1");
		return "home";
	}
	@RequestMapping(value = "/page2",method = RequestMethod.GET)
	public String page2(Model model) {
		
		model.addAttribute("BODY", "PAGE2");
		return "home";
	}
	@RequestMapping(value = "/page3",method = RequestMethod.GET)
	public String page3(Model model) {
		
		model.addAttribute("BODY", "PAGE3");
		return "home";
	}
	@RequestMapping(value = "/page4",method = RequestMethod.GET)
	public String page4(Model model) {
		
		model.addAttribute("BODY", "PAGE4");
		return "home";
	}
	@RequestMapping(value = "/page5",method = RequestMethod.GET)
	public String page5(Model model) {
		
		model.addAttribute("BODY", "PAGE5");
		return "home";
	}
	@RequestMapping(value = "/page6",method = RequestMethod.GET)
	public String page6(Model model) {
		
		model.addAttribute("BODY", "PAGE6");
		return "home";
	}
	@RequestMapping(value = "/page7",method = RequestMethod.GET)
	public String page7(Model model) {
		
		model.addAttribute("BODY", "PAGE7");
		return "home";
	}
	
	@RequestMapping(value = "/page8",method = RequestMethod.GET)
	public String page8(Model model) {
		
		model.addAttribute("BODY", "PAGE8");
		return "home";
	}
	
	@RequestMapping(value = "/page9",method = RequestMethod.GET)
	public String page9(Model model) {
		
		model.addAttribute("BODY", "PAGE9");
		return "home";
	}
}
