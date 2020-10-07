package com.biz.book.service;

import java.util.List;

/*
 * 한가지 vo클래스에 종속되지 않은 
 * 여러가지 vo를 클래스를 사용한 인터
 */
public interface NaverService<T> {
	
	//
	// naver api의 요청 url 문자열을 생성
	public String queryURL(String category, String search_text);
	
	//
	// 
	public String getNaverSearch(String queryURL);
	public List<T> getNaverList(String jSonString);
}
