package com.biz.book.mapper;

import java.util.List;

public interface GenericDao<VO,PK> {
	
	public List<VO> selectAll();
	public VO findById();
	public int insert();
	public int update();
	public int delete();
}