package com.biz.book.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.biz.book.model.AuthorityVO;
import com.biz.book.model.UserDetailsVO;

/*
 * member table에서 user 정보를 select 하여 권한을 관리하는 클래스
 * 
 * spring security 에서 사용자 인증, 권한 부여 절차
 * 사용자가 login form에  username, password를 입렧한 후 로그인을 시도하면
 * 1. AuthenticationProvider 인터페이스를 구현한 AuthProviderImpl 객체를 찾는다
 * 2. authenticate() method를 호출한다.
 * 		이때 spring security는 Authentication 객체에 로그인한
 * 		username, password를 실어서 정달한다.
 * 3. Authentication 객체에서
 * 		principal(username), credential(password)
 * 
 * 
 * UserDetailServiceImpl로 부터 return받은 user
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class AuthProviderImpl implements AuthenticationProvider{

	@Autowired
	@Qualifier("userDetailServiceV1")
	private UserDetailsService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/*
	 * 사용자가 로그인을 수행햇을때 username과, password를 주입받아소
	 * 정상적인 사용자인가를 검사하는 method
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		// 로그인한 사용자의 username과 password를 authentication 객체로 부터 getter
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		//로그인 인증하는 부분...
		// 1. userdeta
		UserDetailsVO userVO = (UserDetailsVO) userService.loadUserByUsername(username);
		
		//
		//
		/*
		if(!password.equals(userVO.getPassword())) {
			throw new BadCredentialsException("비밀번호 오류!");
		};
		*/
		
		// PasswordEncoder로 암호화된 비번 비교
		/*
		 * 사용자가 입력한 password 평문 문자열을 내부에서
		 * 암호화 하여 db에 저장되어 있는 암호화된 비번(userVO.getPassword())
		 * 비교하여 일치하는지 검사한다.
		 */
		if(!passwordEncoder.matches(password, userVO.getPassword())) {
			throw new BadCredentialsException("비밀번호 오류!");
		};
		
		//
		if(!userVO.isEnabled()) {
			throw new BadCredentialsException(username + " 사용자 정보 사용불가!!");
		}
		
		// 4. (임시) 사용자의 권한 리스트를 생성
		List<AuthorityVO> authList = new ArrayList<AuthorityVO>();
		authList.add(AuthorityVO.builder().m_role("ROLE_ADMIN").build());
		authList.add(AuthorityVO.builder().m_role("ROLE_USER").build());
		
		List<GrantedAuthority> rollList = new ArrayList<GrantedAuthority>();
		
		for (AuthorityVO auth : authList) {
			rollList.add(new SimpleGrantedAuthority(auth.getM_role()));
		}
		
		//로그인한 사용자에게 인증 token을 발생
		// 사용자의 detail정보와 roll정보를 token에 같이 심어 놓는다.
		return new UsernamePasswordAuthenticationToken(userVO, null,rollList);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// supports() 의 return값이 false이면 ...token을 사용하지 않겠다
		// 반드시 여기를 true
		return true;
	}

}
