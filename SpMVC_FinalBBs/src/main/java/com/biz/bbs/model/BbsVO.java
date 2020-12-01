package com.biz.bbs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BbsVO {

	private Long id;//	number
	private String first_name;//	nvarchar2(30 char)
	private String last_name;//	nvarchar2(30 char)
	private String address;//	nvarchar2(125 char)
	private String tel;//	varchar2(20 byte)
	private String email;//	varchar2(125 byte)
}
