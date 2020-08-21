package com.biz.shop.service;

import java.util.List;

import com.biz.shop.model.ProductVO;

/**
 * GenericService interface
 * @param <VO>
 * @param <PK>
 * 
 * DB와 관련된 를 수행할때
 * 클래스를 만들기에 앞서 
 * 인터페이스를 만들도록 권하고 있다
 * 
 * 다수의 이  존재하는 프로젝트일 경우 비슷한 이름의 를
 * 중복하여 선언해야 하는 경우가 많다.
 * 
 * 이런경우에 인터페이스를 만들기 위한 상위 인터페익스를 선언하고
 * 인터페이스에 을 선언해 둔다
 * 
 * 이 인터페이스를 상속받아소 실제 하용할 인터페리스를 선언해주면
 * 
 */
public interface GenericService<VO,PK> {
	
	public List<VO> selectAll();
	public VO findByID(PK id);
	
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK id);
	
}
