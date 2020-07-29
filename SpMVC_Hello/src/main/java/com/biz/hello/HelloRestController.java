package com.biz.hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biz.hello.service.HelloService;
import com.biz.hello.service.ScoreService;

@RestController
public class HelloRestController {
	
	/*
	 * @Autowired
	 * 프로젝트에서  @Annotation으로 설정된 클래스들을 객체로 생성한
	 * 컨테이너가 있으며
	 * 
	 * 컨테이너가 저장된 객체를 찾아서 선언된 객체에 주입하여 초기화, 사용할수 잇도록 만들어준다
	 * 
	 */
	@Autowired
	private HelloService hService;
	
	@Autowired
	private ScoreService sService;
	
	@Autowired
	private HelloController hController;
	
	/*
	public HelloRestController() {
		// TODO Auto-generated constructor stub
		hService = new HelloServiceImpl();
		sService = new ScoreService();
	}
	*/
	
	//spring framework에서 권장하는 생성자
	/*
	 * 프로젝트에서는 외부의 클래스르르 객체로 만들때
	 * 직접 new 생성자를 사용하여 만들지 않는다
	 * 
	 * 프로젝드가 시작될때 이 붙어있는 모든 클래스는 이미 객체로 생성되어
	 * 에 저장되있다
	 * 
	 *  다른 클래스를 객체로 생성하여 사용이 필요한곳이 있으면
	 *  에서 객체를 꺼내서 직접 주입해준다.
	 *  
	 *   : 의존성 주입, 필요한곳에 주입, 필요한
	 */
//	public HelloRestController(HelloService hService, ScoreService sService) {
//		// TODO Auto-generated constructor stub
//		this.hService = hService;
//		this.sService = sService;
//	}
	
	
	@RequestMapping(value = "/rest")
	public String rest(Model model) {
		
		model.addAttribute("myname", "Korea" );
		
		return "Republic of Korea";
	}
	
	@RequestMapping(value = "/null")
	public String mNull(Model model) {
		
		model.addAttribute("myname", "Korea" );
		
		return null;
	}
	
	@RequestMapping(value = "/int")
	public String hello() {
		int ret = hService.add(20, 40);
		return ret + "";
	}
	
	/*
	 * 클래스를 객체로 만들어서 method를 호출하는 경우
	 * 가장 많이 발생하는 중의 하나
	 * 
	 * 클래스를 객체로 선언은 했으나 초기화, 생성을 하지 않은 경우
	 * 
	 * 이 메서드에서 intList=new ArrayList<Integer>(); 을 생략하면
	 * List 
	 */
	public void nullPointer() {
	
		List<Integer> intList = null;
		intList=new ArrayList<Integer>();
		intList.add(100);
		
	}
	
}

