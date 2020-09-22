package com.biz.book.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 *  객체들을 
 *  
 *  restTemplate 기능을 사용하여 api 데이터를 가져오기 위한
 *  핵심 기능을 사용하기 위한 매우 중요한 model 클래스
 *  api를 통해 갸져올 데이터들을 담을ㅇ list를 성언하는
 */
@XmlRootElement(name="rss")
public class Book_XML_Parent {
	
	@XmlElement(name="channel")
	public Book_XML_Channel channel;
}
