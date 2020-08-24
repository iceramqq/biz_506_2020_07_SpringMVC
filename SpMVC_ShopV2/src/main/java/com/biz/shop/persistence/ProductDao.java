package com.biz.shop.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.shop.model.ProductVO;

public interface ProductDao extends GeneriDao<ProductVO, String> {
	
	/*
	 * 이산에서
	 */
	
	@Select("select * from tbl_product")
	@Override
	public List<ProductVO> selectAll();

	public List<ProductVO> findByTitle(String title);
	
	@Select("select max(p_code) from tbl_product")
	public String maxPCode();
	
	@Select("select from tbl_product where p_code = #{id}")
	@Override
	public ProductVO findByID(String id);
	

}
