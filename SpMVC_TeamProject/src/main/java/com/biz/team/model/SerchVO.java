package com.biz.team.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
public class SerchVO {

	private String addr1;
	private String addr2;
	private String areacode;
	private String cat1;
	private String cat2;
	private String cat3;
	private String contentid;
	private String contenttypeid;
	private String createdtime;
	private String firstimage;
	private String firstimage2;
	private String mapx;
	private String mapy;
	private String mlevel;
	private String modifiedtime;
	private String readcount;
	private String sigungucode;
	private String title;
	private String zipcode;
}
