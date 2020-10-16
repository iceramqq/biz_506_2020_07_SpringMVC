package com.biz.team.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.biz.team.model.SerchVO;
import com.biz.team.model.Serch_XML_Parent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SerchService {

	public String queryURL() {

		String queryURL = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey="
				+ "tP218HXX2qhSpG8LjT2pITaRqj2y1FtF8JUHbMS405nVslpIpVCbAwVSMMANnIPwD%2BZT%2FA5DOD37COuUNueTRQ%3D%3D"
				+ "&cat1=A02&cat2=A0201&cat3=A02010500&listYN=Y&arrange=Q"
				+ "&MobileOS=ETC&MobileApp=TourAPI3.0_Guide"
				+ "&arrange=A&numOfRows=12&pageNo=1"; 
		return queryURL;
	}

	public List<SerchVO> getNaverList(String queryURL) {
		
		
		URI restURI = null;
		
		
		RestTemplate restTemp = new RestTemplate();
		
		try {
			restURI = new URI(queryURL);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<Serch_XML_Parent> serchList = null;
		
		serchList
			= restTemp.exchange(restURI, 
					HttpMethod.GET,
					entity,
					Serch_XML_Parent.class);
		return serchList.getBody().channel.item;
	
	}
}
