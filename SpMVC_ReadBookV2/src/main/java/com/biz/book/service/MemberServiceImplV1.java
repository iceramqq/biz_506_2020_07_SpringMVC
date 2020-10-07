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
		
		/*
		 * 회원테이블에 값이 없을때 회원가입이 이루어지면
		 * 그 회원을 admin 권한을 갖고
		 * enabled 칼럼을 1세팅하여 즉시 로그인이 가능 하도록
		 * 자바에서 true로 값을 설정하면 오라클에서는 1로 저장
		 * 
		 * 두번째 가입되는 회원
		 * 
		 */
		
		
		int nCount = userDao.userCount();
		if(nCount > 0) {
			userVO.setEnabled(false);
		} else {
			userVO.setEnabled(true);
		}
		// 평문으로 입력된 비밀버호를 암호화된 비밀번호로 대치
		userVO.setPassword(encPassword);
		userDao.insert(userVO);
		
		return 0;
	}
	
	public String userNameAnsPassword(String username,String password) {
		UserDetailsVO userVO = userDao.findById(username);
		
		//
		//
		// 사용자가 입력한 비밀번호와 db에 저장된 비밀번호를
		// 에 매개변수로 전달하면
		// 비밀번호가 일치하는 확인하여 true, false를 리턴한다
		
		//결과값에 따라 3항연사를 사용하ㅕㅇ ok 또는 fail 문자
		return passwordEncoder.matches(password, userVO.getPassword());
	}

	@Override
	public UserDetailsVO findById(String username) {
		// TODO Auto-generated method stub
		UserDetailsVO userVO = userDao.findById(username);
		return userVO;
	}

	@Override
	public int update(UserDetailsVO userVO) {
		// TODO Auto-generated method stub
		
		return userDao.update(userVO);
	}
}
