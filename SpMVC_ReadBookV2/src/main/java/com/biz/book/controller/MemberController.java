package com.biz.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.book.model.UserDetailsVO;
import com.biz.book.service.MemberService;

import lombok.RequiredArgsConstructor;

/*
 * 서버의 메모리에 memberVO 이름으로 객체변수를 마련해 놓는다
 * 
 * 
 * 매개변수가 있으면 메모리에 저장된 객체변수에서 값을 추출하여
 * 객체 포함해 준다
 */
@SessionAttributes("memberVO")
@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	/*
	 * @sessionAttributes(memberVO)를 사용하려면
	 * 반드시 memberVO를 생성하는 method가 클래스에 있어야 된다
	 * userDetailsVO 클래스로 생성된 membervo가 " membervo"이름으로 보괸된다
	 * @sessionAttibutes()있는데 @ModelAttribute가 붙은 method가 없으면 
	 * 컴파일 오류가 난다
	 */
	@ModelAttribute("memberVO")
	public UserDetailsVO newMember() {
		UserDetailsVO memberVO = UserDetailsVO.builder().build();
		return memberVO;
	}
	
	/*
	 * vo클래스를 controller의 매개변수로 설정하고
	 * @modelAttribute("이름")을 설정했을 경우
	 * 1. form에서 POST로 데이터를 보냈을 경우 form에서 보낸 데이터가 담긴
	 * 		vo 객체를 생성하여 method내의 코드에서 사용할수 있도록 준비해준다
	 * 2. 아무도(아무곳에서도) 객체의 필드변수와 일치하는 변수를 전달하지 않을경우
	 * 		자체적으로 클래스의 생성자를 호출하여 비어있는 객체를 만들어서
	 * 		method내에 코드에서 사용할 수 있도록 준비해 준다
	 */
	@RequestMapping(value = "/join",method = RequestMethod.GET)
	public String join(@ModelAttribute("memberVO") UserDetailsVO userVO,Model model) {
		
		model.addAttribute("memberVO",userVO);
		model.addAttribute("BODY","MEMBER-JOIN");
		return "home";
	}
	
	/*
	 * 회원가입 입력ㅎ폼을 2개로 분리하여 사용하기 위해
	 * join get : member-write.jsp가 열리고
	 * join post : member-write2.jsp가 열린다
	 * member-write.jsp에서 입력한 id, 비밀번호를 join post 로 보내면
	 * @modelattribuye("memberVO") 설정을 확인하고
	 * server입시 보관중인 sessionattributes("member")를 찾아서
	 * 입력박스로부터 전달된 데이터를 보관한다
	 * member-write2.jso열고 나머지 데이터를 일력 한후
	 * 
	 */
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(@ModelAttribute("memberVO") UserDetailsVO userVO, Model model,String str) {
		
		model.addAttribute("memberVO",userVO);
		model.addAttribute("BODY","MEMBER-JOIN-NEXT");
		return "home";
	}
	
	/*
	 * @SessionAttributes를 사용할때는
	 * 에 데이터를 를 최종수행하고 나면
	 * 클래스의 를 호출하여
	 * 서버에 남아 있는 메모리를 헤 주어야 한다
	 */
	@RequestMapping(value = "/join_comp",method = RequestMethod.POST)
	public String join(@ModelAttribute("memberVO") UserDetailsVO userVO,SessionStatus status) {
		
		memberService.insert(userVO);
		status.setComplete();
		return "redirect:/";
	}
	
	@RequestMapping(value = "/mypage",method = RequestMethod.GET)
	public String mypage(@ModelAttribute("memberVO") UserDetailsVO userVO,Authentication authentication,Model model) {
		
		userVO = (UserDetailsVO) authentication.getPrincipal();
		userVO.setPassword("");
		model.addAttribute("memberVO",userVO);
		model.addAttribute("BODY","MEMBER-UPDATE");
		return "home";
	}
	
	@RequestMapping(value = "/mypage",method = RequestMethod.POST)
	public String mypage(@ModelAttribute("memberVO") UserDetailsVO userVO, Model model,String str) {
		
		model.addAttribute("memberVO",userVO);
		model.addAttribute("BODY","MEMBER-UPDATE-NEXT");
		return "home";
	}
	
	@RequestMapping(value = "/update_comp",method = RequestMethod.POST)
	public String update(@ModelAttribute("memberVO") UserDetailsVO userVO,SessionStatus status) {
		
		memberService.update(userVO);
		status.setComplete();
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value = "/password_check",method = RequestMethod.POST)
	public String password_check(String username, String password) {
		
		memberService.
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/id_check",method = RequestMethod.POST)
	public String id_check(String username) {
		
		//
		//
		// 문법 오류가 발생하면 구체적으로
		UserDetailsVO userVO = memberService.findById(username);
		// userVO 가 null이면 username이 db에 없다
		if(userVO == null) {
			return "OK";
		} else {
			return "FAIL";
		}
		
	}
	
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public String logout() {
		return "member/logout";
	}
}
