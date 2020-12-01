package com.biz.bbs.service;

import java.util.List;

import com.biz.bbs.model.BbsVO;

public interface BbsService {

	public List<BbsVO> selectAll();
	public BbsVO findById(Long id);
	
	public int insert(BbsVO bbsVO);
	public int update(BbsVO bbsVO);
	public int delete(Long id);
}
