package com.biz.shop.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.shop.model.ProductVO;

public interface ProductDao extends GenericDao<ProductVO, String> {
	
	/*
	 * 이산에서
	 */
	
	@Select("SELECT * FROM tbl_product WHERE p_not_use IS NULL")
	@Override
	public List<ProductVO> selectAll();

	public List<ProductVO> findByTitle(String title);
	
	@Select("select max(p_code) from tbl_product")
	public String maxPCode();
	
	@Select("SELECT * FROM tbl_product WHERE p_not_use IS NULL and p_code = RPAD(#{id},6,' ')")
	@Override
	public ProductVO findByID(String id);
	

}
