package com.biz.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.ems.mapper.EmsDao;
import com.biz.ems.model.EmsVO;

@Service("emsServiceV1")
public class EmsServiceImplV1 implements EmsService{

	@Autowired
	private EmsDao emsDao;
	
	@Override
	public List<EmsVO> selectAll() {
		
		List<EmsVO> emsList = emsDao.selectAll();
		return emsList;
	}

	@Override
	public EmsVO findById(long id) {
		
		EmsVO emsVO = emsDao.findById(id);
		return emsVO;
	}

	@Override
	public int insert(EmsVO emsVO) {
		
		int ret = emsDao.insert(emsVO);		
		return ret;
	}

	@Override
	public int update(EmsVO emsVO) {
		// TODO Auto-generated method stub
		return emsDao.update(emsVO);
	}

	@Override
	public int delete(long id) {
		int ret = emsDao.delete(id);
		return 0;
	}

}
