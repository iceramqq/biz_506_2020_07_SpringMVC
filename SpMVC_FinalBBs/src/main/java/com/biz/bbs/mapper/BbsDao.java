package com.biz.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;

import com.biz.bbs.SQL.BbsSQL;
import com.biz.bbs.model.BbsVO;

public interface BbsDao {

	@Select("select * from tbl_employees order by id desc")
	public List<BbsVO> selectAll();
	
	@Select("select * from tbl_employees where id = #{id}")
	public BbsVO findById(Long id);
	
	@InsertProvider(type=BbsSQL.class,method="insert")
	public int insert(BbsVO bbsVO);
	
	@InsertProvider(type=BbsSQL.class,method="update")
	public int update(BbsVO bbsVO);
	
	@Delete("DELETE FROM tbl_employees where id = #{id}")
	public int delete(Long id);
	
}
