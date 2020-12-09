package com.biz.data.service;

import java.util.List;

import com.biz.data.model.BisDestVO;
import com.biz.data.model.BisStationData;

public interface BisService {
	
	// 데이터를 vo에 담아서 추출
	public List<BisStationData> getStation();
	
	// 문자열 형태로 
	public String getString();

	public List<BisDestVO> busstop(String station);
}
