package com.biz.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.shop.model.ProductVO;
import com.biz.shop.persistence.ProductDao;
import com.biz.shop.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(value = "proServiceV1")
public class ProductServiceImplV1 implements ProductService{
	
	@Autowired
	private ProductDao proDao;
	
	@Override
	public List<ProductVO> selectAll() {
		
		return proDao.selectAll();
	}

	@Override
	public ProductVO findByID(String id) {
		// TODO Auto-generated method stub
		return proDao.findByID(id);
	}

	@Override
	public int insert(ProductVO vo) {
		// TODO Auto-generated method stub
		
		vo.setP_image("이미지 없음");
		int ret = proDao.insert(vo);
		
		if(ret>0) {
			log.debug("INSERT 성공 {} 개 데이터 추가",ret);
		} else {
			log.debug("INSERT 실패 {}",ret);
		}
		
		return 0;
	}

	@Override
	public int update(ProductVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProductVO> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPCode() {
		// TODO Auto-generated method stub
		
		String strMaxPCode = proDao.maxPCode();
		log.debug("조회한 상품코드 : {}",strMaxPCode);
		
		String retPCode = "P00001";
		try {
			String preCode = strMaxPCode.substring(0,1);
			String pCode = strMaxPCode.substring(1);
			log.debug("분리된 상품코드 : {},{}",preCode, pCode);
			
			retPCode = String.format("%s%05d", preCode, Integer.valueOf(pCode)+1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		log.debug("새로 생성된 상품코드: {}",retPCode);
		
		return retPCode;
	}

}
