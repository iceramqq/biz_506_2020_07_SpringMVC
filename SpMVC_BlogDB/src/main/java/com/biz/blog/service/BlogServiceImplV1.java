package com.biz.blog.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.biz.blog.dao.BlogDao;
import com.biz.blog.model.BlogVO;

/*
 * 
 */
@Service
public class BlogServiceImplV1 implements BlogService{
	
	//
	//를 빼먹으면? : nullpointerEx
	@Autowired
	//
	//
	private SqlSession sqlSession;

	@Override
	public List<BlogVO> selectAll() {
		// BlogDao와 SqlSession을 연동하여 연결 구성
		// 에게 인터페이스와 파일을 참조하여
		// 인토페이스를 구현한 클래스를 만들고 객체로 생성하여
		// 사용할 수 있도록 해달라
		BlogDao blogDao = sqlSession.getMapper(BlogDao.class);
		List<BlogVO> blogList = blogDao.selectAll();
		
		return blogList;
	}

	@Override
	public BlogVO findBySeq(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BlogVO blogVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BlogVO blogVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long seq) {
		// TODO Auto-generated method stub
		return 0;
	}



}
