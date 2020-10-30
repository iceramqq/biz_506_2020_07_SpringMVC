package com.biz.grade.service;

import java.util.List;

import com.biz.grade.model.GradeVO;

public interface GradeService {

	public List<GradeVO> selectAll();
	public int insert(GradeVO gradeVO);
	public GradeVO findById(String g_id);
	public int delete(String g_id);
	public int update(GradeVO gradeVO);
}
