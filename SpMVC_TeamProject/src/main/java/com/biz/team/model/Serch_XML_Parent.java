package com.biz.team.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="response")
public class Serch_XML_Parent {
	
	@XmlElement(name="item")
	public Serch_XML_Channel channel;
}
