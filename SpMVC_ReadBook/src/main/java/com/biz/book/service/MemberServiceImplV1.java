package com.biz.book.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.biz.book.mapper.AuthorityDao;
import com.biz.book.mapper.UserDao;
import com.biz.book.model.UserDetailsVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("memberServiceV1")
/*
 * memberServiceImplV1클래스의 필드변수가 잇는 생성자를 자동으로 
 * private final 로 선언된 객체에 cotainer로 부터 객체를 주입받아 사용할수 있도록 만들어주는
 * lombok의 annotation
 */
@RequiredArgsConstructor
public class MemberServiceImplV1 implements MemberService{

	@Qualifier("passwordEncoder")
	private final PasswordEncoder passwordEncoder;
	
	// 회원정보 crud 구현
	private final UserDao userDao;
	
	// 회원의 권한정보 crud구현
	private final AuthorityDao authDao;
	
	/*
	 * 컨트로러에서 회원정보를 전달받아서
	 * 비밀번호를 암호화 하고
	 * 
	 */

	public int insert(UserDetailsVO userVO) {
		
		String password = userVO.getPassword();
		String encPassword = passwordEncoder.encode(password);
		log.debug("password {} , encPassword {}",password,encPassword);
		
		// 평문으로 입력된 비밀버호를 암호화된 비밀번호로 대치
		userVO.setPassword(encPassword);
		userDao.insert(userVO);
		
		return 0;
	}
}
