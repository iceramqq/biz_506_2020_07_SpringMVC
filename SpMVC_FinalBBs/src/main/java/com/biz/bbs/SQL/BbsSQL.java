package com.biz.bbs.SQL;

import org.apache.ibatis.jdbc.SQL;

public class BbsSQL {

	public String insert() {
		SQL sql = new SQL();
		sql.INSERT_INTO("tbl_employees");
		
		sql.INTO_COLUMNS("id").INTO_VALUES("${id}");
		sql.INTO_COLUMNS("first_name").INTO_VALUES("#{first_name}");
		sql.INTO_COLUMNS("last_name").INTO_VALUES("#{last_name}");
		sql.INTO_COLUMNS("address").INTO_VALUES("#{address}");
		sql.INTO_COLUMNS("tel").INTO_VALUES("#{tel}");
		sql.INTO_COLUMNS("email").INTO_VALUES("#{email}");

		return sql.toString();
	}
	
	public String update() {
		SQL sql = new SQL();
		sql.UPDATE("tbl_employees");
		sql.SET("first_name = #{first_name}");
		sql.SET("last_name=#{last_name}");
		sql.SET("address=#{address}");
		sql.SET("tel=#{tel}");
		sql.SET("email=#{email}");
		sql.WHERE("id=${id}");
		return sql.toString();
	}
}
