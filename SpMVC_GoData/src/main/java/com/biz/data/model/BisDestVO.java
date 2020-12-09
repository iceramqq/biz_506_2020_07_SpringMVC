package com.biz.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BisDestVO {

	// ARRIVE_LIST
	private String ARRIVE;
	private String LINE_ID;
	private String LINE_NAME;
	private String BUS_ID;
	private String METRO_FLAG;
	private String CURR_STOP_ID;
	private String BUSSTOP_NAME;
	private String REMAIN_MIN;
	private String REMAIN_STOP;
	private String DIR_START;
	private String DIR_END;
	private String LOW_BUS;
	private String ENG_BUSSTOP_NAME;
	private String ARRIVE_FLAG;
	private String LINE_KIND;

}
