package com.biz.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biz.order.model.OrderVO;
import com.biz.order.service.OrderService;

@Controller
public class OrderController {
	/*
	 * 를 사용하여  를 선언하고 
	 * 이미생성되어 에 보관중인 객체를
	 * 에 주입하라
	 * 결국 객체를 통하여 method를 호출할 준비가 된다.
	 */
	@Autowired
	private OrderService oService;
	
	@RequestMapping(value = "/order")
	public String getOrder(Model model) {
		
		// 서비스에 를 전달하고
		// 데이터 레코드를 한 결과를 받아서
		// 에 담는다
		OrderVO orderVO = oService.findBySeq(11);
		
		/*
		 * 
		 */
		model.addAttribute("ORDER",orderVO);
		
		/*
		 * 이때 method에 담겨있는 데이터를 rendering 할때 사용하라
		 */
		return "order/view";
		
	}
	
}
