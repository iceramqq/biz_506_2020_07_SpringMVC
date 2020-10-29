package com.biz.ems.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.ems.model.EmsVO;

public interface EmsDao {

	@Select("select * from tbl_ems order by s_date desc, s_time desc")
	public List<EmsVO> selectAll();
	
	@InsertProvider(type = EmsSQL.class,method = "insert")
	public int insert(EmsVO emsVO);
	
	@Select("select * from tbl_ems where id = #{id}")
	public EmsVO findById(long id);
	
	@Delete("delete tbl_ems where id = #{id}")
	public int delete(long id);
	
	@UpdateProvider(type = EmsSQL.class,method = "update")
	public int update(EmsVO emsVO);

}
