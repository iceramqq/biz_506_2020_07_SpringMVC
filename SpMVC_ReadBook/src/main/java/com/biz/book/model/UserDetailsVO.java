package com.biz.book.model;

import java.util.Collection;

import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Alias("UserDetail")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDetailsVO implements UserDetails{
	
	/*
	 * http 프로토콜을 통헤서 vo를 주고 받을때
	 * 데이터 json 형태로 이동이 되는데
	 * 일렬로 나열된 문자열 형태로 네트워크를 통해서 이동한다
	 * 이때 
	 */
	private static final long serialVersionUTD = 1L;
	
	private long id;
	private String username;
	private String password;
	
	private boolean enabled;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	// 프로젝트에서 필요한
	private String m_name;
	private String m_tel;
	private String m_email;
	private String m_address;
}
