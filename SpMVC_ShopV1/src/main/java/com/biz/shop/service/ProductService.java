package com.biz.shop.service;

import java.util.List;

import com.biz.shop.model.ProductVO;

/*
 * 
 * 
 * 필요한 추가 가 있으면 별도로 선언을 해주고
 * 이 인터페이스를 한 클래스느느 인터페이스를 한 클래스는 인터페이스의 영항을 받아 
 * 를 구현하게 된다.
 */
public interface ProductService extends GenericService<ProductVO, String>{
	
	public List<ProductVO> findByTitle(String title);
	
}
