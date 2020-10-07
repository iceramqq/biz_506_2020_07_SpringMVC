package com.biz.book.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.biz.book.config.NaverSecret;
import com.biz.book.model.Book_JSON_Parent;
import com.biz.book.model.BookVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("naverServiceV2")
public class NaverServiceImplV2 extends NaverServiceImplV1 {
	
	public String queryURL(String category, String bookName) {
		
		log.debug(category);
		String queryURL = NaverSecret.NAVER_BOOK_JSON;
		String encodeText = null;
		try {
			//한글 검색을 위해서 검색어를 UTF로 encoding 처리해주어야 한다.
			encodeText = URLEncoder.encode(bookName.trim(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// url?query=자바
		queryURL += String.format("?query=%s",encodeText);
		
		// 한번에 조회할 데이터 개수를 지정할수 있다
		queryURL += "&display=10"; 
		return queryURL;
	}
	
	
	
	//
	//
	
	// 3개의 method중에서 getNaverList(jsonString) method만 upgrade하겠다
	@Override
	public List<BookVO> getNaverList(String queryURL) {
		
		// queryurl 문자열을 uri 객체로 만들어
		// http프로토콜에서 사용할 수 있도록 만드는 클래스
		// 기존에 url 클래스가 있으나, 새로운 기능을 수행하기 위해서
		// 별도의 uri 클래스를 만들어 놨으며
		// 많은 기능들이 추가되어 있다.
		// restTamplate를 사용하기 위해서는
		// queryUrl 문자열을 url 객체가 아닌 uri 객체오 만들어야 한다.
		URI restURI = null;
		
		/*
		 * springframewok에서 외부 api를 사용하여 데이터를 가져올 때
		 * 기존에는 json 형식으로 가져올일이 점점 많아 지면서
		 * 
		 */
		RestTemplate restTemp = new RestTemplate();
		
		try {
			restURI = new URI(queryURL);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("x-Naver-Client-Id",NaverSecret.NAVER_CLIENT_ID);
		headers.set("x-Naver-Client-Secret",NaverSecret.NAVER_CLIENT_SECRET);
		
		HttpEntity<String> entity = new HttpEntity<String>("parameter",headers);
		
		
		ResponseEntity<Book_JSON_Parent> bookList = null;
		
		bookList = restTemp.exchange(restURI,HttpMethod.GET,entity, Book_JSON_Parent.class);
		log.debug(bookList.toString());
		return bookList.getBody().items;
	}
	
}
