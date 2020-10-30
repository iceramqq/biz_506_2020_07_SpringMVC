package com.biz.grade.service;

import java.util.List;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.grade.mapper.GradeDao;
import com.biz.grade.model.GradeVO;

@Service("gradeServiceV1")
public class GradeServiceImplV1 implements GradeService {

	@Autowired
	private GradeDao gradeDao;

	@Override
	public List<GradeVO> selectAll() {
		// TODO Auto-generated method stub
		return gradeDao.selectAll();
	}

	@Override
	public int insert(GradeVO gradeVO) {
		// TODO Auto-generated method stub
		int sum = gradeVO.getG_kor() + gradeVO.getG_eng() + gradeVO.getG_math();
		float avg = (float) sum / 3;
		gradeVO.setG_sum(sum);
		gradeVO.setG_avg(avg);
		return gradeDao.insert(gradeVO);
	}

	@Override
	public GradeVO findById(String g_id) {
		// TODO Auto-generated method stub
		return gradeDao.findById(g_id);
	}

	@Override
	public int delete(String g_id) {
		// TODO Auto-generated method stub
		return gradeDao.delete(g_id);
	}

	@Override
	public int update(GradeVO gradeVO) {
		// TODO Auto-generated method stub
		int sum = gradeVO.getG_kor() + gradeVO.getG_eng() + gradeVO.getG_math();
		float avg = (float) sum / 3;
		gradeVO.setG_sum(sum);
		gradeVO.setG_avg(avg);
		return gradeDao.update(gradeVO);
	}

}
