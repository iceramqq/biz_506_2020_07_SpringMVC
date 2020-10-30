package com.biz.grade.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.grade.model.GradeVO;
import com.biz.grade.sql.gradeSQL;

public interface GradeDao {

	@Select("select * from tbl_grade order by g_id")
	public List<GradeVO> selectAll();
	
	@InsertProvider(type=gradeSQL.class,method="grade_insert")
	public int insert(GradeVO gradeVO);
	
	@Select("select * from tbl_grade where g_id = #{g_id}")
	public GradeVO findById(String g_id);
	
	@Delete("delete tbl_grade where g_id = #{g_id}")
	public int delete(String g_id);
	
	@UpdateProvider(type=gradeSQL.class,method="grade_update")
	public int update(GradeVO gradeVO);
}
