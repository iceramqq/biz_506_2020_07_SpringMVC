package com.biz.blog.service;

import java.util.List;

import com.biz.blog.model.BlogVO;

public interface BlogService {
	
	public List<BlogVO> selectAll();
	
	// 이결과값은 반드시 List형 이다
	public BlogVO findBySeq(String title);
	
	//
	//성공을 하면 1이상의 리턴결과를 정수형으로 리턴한다
	public int insert(BlogVO blogVO);
	public int update(BlogVO blogVO);
	public int delete(long seq);
	
}
