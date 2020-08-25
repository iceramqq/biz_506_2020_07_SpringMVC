package com.biz.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.shop.model.DeptVO;
import com.biz.shop.persistence.DeptDao;
import com.biz.shop.service.DeptService;

@Service(value = "deptServiceV1")
public class DeptServiceImplV1 implements DeptService {
	
	@Autowired
	private DeptDao deptDao;
	
	@Override
	public List<DeptVO> selectAll() {
		
		return deptDao.selectAll();
	}

	@Override
	public DeptVO findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(DeptVO vo) {
		
		int ret = deptDao.insert(vo);
		
		return ret;
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

	@Override
	public String getDCode() {
		// TODO Auto-generated method stub
		
		
		return null;
	}

}
