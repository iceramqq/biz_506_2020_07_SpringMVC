package com.biz.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.shop.model.DeptVO;
import com.biz.shop.persistence.DeptDao;
import com.biz.shop.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(value = "dServiceV1")
public class DeptServiceImplV1 implements DeptService {
	
	@Autowired
	private DeptDao dDao;
	
	
	@Override
	public List<DeptVO> selectAll() {
		// TODO Auto-generated method stub
		return dDao.selectAll();
	}

	@Override
	public DeptVO findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(DeptVO vo) {
		// TODO Auto-generated method stub
		int ret = dDao.insert(vo);
		return 0;
	}

	@Override
	public int update(DeptVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
