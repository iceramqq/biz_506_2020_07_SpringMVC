package com.biz.data.config;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

/**
 * RestTemplate 을 사용하여 openapi데이터를 가져올때
 * httpheader에 apllication_json, apllication_xml형식을
 * 지정했음에도 불구하고
 * openapi 데이터를  제공하는 곳에서
 * application/json, application/xml 형식으로 데이터를 보내는 경우
 * vo클
 *
 */
public class RestTempInterceptor implements ClientHttpRequestInterceptor{

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {

		ClientHttpResponse response = execution.execute(request, body);
		response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
		
		return response;
	}

}
