package com.biz.order.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.order.dao.OrderDao;
import com.biz.order.model.OrderVO;

@Service
public class OrderServiceImplV1 implements OrderService{
	
	@Autowired
	private SqlSession sqlSession;
	
	private OrderDao orderDao;
	
	@Autowired
	public void getMapper() {
		this.orderDao = sqlSession.getMapper(OrderDao.class);
	}
	
	@Override
	public List<OrderVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * seq값을 파라메터로 받아서 
	 * orderDao.finBySeq(seq)를 호출하고 db로 부터 전달되어온
	 * 주문서 1개의 레코드를 에 받고 
	 * 호출한
	 */
	
	@Override
	public OrderVO findBySeq(long seq) {
		// TODO Auto-generated method stub
		
		// 11
		OrderVO orderVO = orderDao.findBySeq(seq);
		return orderVO;
	}

	@Override
	public int insert(OrderVO orderVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(OrderVO orderVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long seq) {
		// TODO Auto-generated method stub
		return 0;
	}

}
