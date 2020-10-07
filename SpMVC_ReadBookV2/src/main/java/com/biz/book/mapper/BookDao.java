package com.biz.book.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.biz.book.model.BookVO;

public interface BookDao extends GenericDao<BookVO, Long> {
	
	@Select("select * from tbl_books where seq = #{id}")
	public BookVO findById(long id);
	
	@Delete("delete from tbl_books where seq = #{id}")
	public int delete(long id);
	
}
