package com.biz.shop.model;

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
public class ProductVO {
	private String p_code;
	private String p_name;
	private String p_dcode;
	private String p_std;
	private int p_iprice;
	private int p_oprice;
	private String p_image;
	
	//
	// 사용하는 type  dl 
	// 메모리 공간 크기가 1byte(8bit)
	//
	//
	// 단순히 와 같은 데이터를 취급할때는 형으로 사용하면
	// 메모리를 절약할 수 있다.
	
	/*
	 * 칼럼의 값이 null이면 정상적인 데ㅣㅇ터이고
	 * null이 아니면 이면 삭제된 데이터로 취급하기로 하였다
	 * 를 수행할때 vo위 칼럼에 값이  null이면 에 수행 설정 때문에 
	 * db에 업데이트할때 null이 아닌 다른 값이 저장되어 버린다
	 * 수행하기전에 vo에 해당 칼럼의 갓ㅂ을 강제로 null로 해줄필요가 잇다
	 * 하지만 기본형인 변수는 null을 저장하여 db로 보낼수 없다
	 * 
	 */
	private Byte p_not_use;

}
