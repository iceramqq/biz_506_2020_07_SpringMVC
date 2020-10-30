package com.biz.grade.sql;

import org.apache.ibatis.jdbc.SQL;

public class gradeSQL {

public String grade_insert() {
		
		SQL sql = new SQL();
		sql.INSERT_INTO("tbl_grade");
		sql.INTO_COLUMNS("g_id").INTO_VALUES("#{g_id}");
		sql.INTO_COLUMNS("g_name").INTO_VALUES("#{g_name}");
		sql.INTO_COLUMNS("g_kor").INTO_VALUES("#{g_kor}");
		sql.INTO_COLUMNS("g_eng").INTO_VALUES("#{g_eng}");
		sql.INTO_COLUMNS("g_math").INTO_VALUES("#{g_math}");
		sql.INTO_COLUMNS("g_sum").INTO_VALUES("#{g_sum}");
		sql.INTO_COLUMNS("g_avg").INTO_VALUES("#{g_avg}");

		return sql.toString();
		
	}

	public String grade_update() {
		
		SQL sql = new SQL();
		sql.UPDATE("tbl_grade");
		sql.SET("g_name= #{g_name}");
		sql.SET("g_kor= #{g_kor}");
		sql.SET("g_eng= #{g_eng}");
		sql.SET("g_math= #{g_math}");
		sql.SET("g_sum= #{g_sum}");
		sql.SET("g_avg= #{g_avg}");
		sql.WHERE("g_id = #{g_id}");
		
		return sql.toString();
	}
}
