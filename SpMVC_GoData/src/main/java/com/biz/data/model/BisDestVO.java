package com.biz.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * jackbind와 springFramwork의 버전문제로
 * vo클래스의 변수들을 모두 public으로 선언해야만
 * 
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BisDestVO {

	// ARRIVE_LIST
	public String ARRIVE;
	public String LINE_ID;
	public String LINE_NAME;
	public String BUS_ID;
	public String METRO_FLAG;
	public String CURR_STOP_ID;
	public String BUSSTOP_NAME;
	public String REMAIN_MIN;
	public String REMAIN_STOP;
	public String DIR_START;
	public String DIR_END;
	public String LOW_BUS;
	public String ENG_BUSSTOP_NAME;
	public String ARRIVE_FLAG;
	public String LINE_KIND;

}
