package com.biz.hello.service;

import org.springframework.stereotype.Service;

@Service
public interface HelloService {
	
	
	public int add(int num1, int num2);
	
	public float add(float num1, float num2);
	
	public String add(String str1,String str2);

}
