package com.biz.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.bbs.mapper.BbsDao;
import com.biz.bbs.model.BbsVO;

@Service
public class BbsServiceImplV1 implements BbsService{
	
	@Autowired
	private BbsDao bbsDao;

	@Override
	public List<BbsVO> selectAll() {
		// TODO Auto-generated method stub
		return bbsDao.selectAll();
	}

	@Override
	public BbsVO findById(Long id) {
		// TODO Auto-generated method stub
		return bbsDao.findById(id);
	}

	@Override
	public int insert(BbsVO bbsVO) {
		// TODO Auto-generated method stub
		bbsDao.insert(bbsVO);
		return 0;
	}

	@Override
	public int update(BbsVO bbsVO) {
		// TODO Auto-generated method stub
		bbsDao.update(bbsVO);
		return 0;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		bbsDao.delete(id);
		return 0;
	}

}
