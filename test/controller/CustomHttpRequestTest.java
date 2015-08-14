package controller;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class CustomHttpRequestTest {
	CustomHttpRequest request;

	@Before
	public void before() {
		request = new CustomHttpRequest();
	}
	
	@Test
	public void parseRequestLine() throws Exception {
		String requestLine = "GET /create?userId=javajigi&password=password&name=%EB%B0%95%EC%9E%AC%EC%84%B1&email=javajigi%40slipp.net HTTP/1.1";
		request.parseRequestLine(requestLine);
		
		assertEquals("GET",request.getMethod());
		assertEquals("javajigi", request.getParameter("userId"));
		assertEquals("password", request.getParameter("password"));
		assertEquals("/create", request.getRequestURI());	
	}

	@Test
	public void parseUri() {
		String uriLine = "/create?userId=javajigi&password=password";
		String[] parsed = request.parseUri(uriLine);

		assertEquals("/create", parsed[0]);
		assertEquals("userId=javajigi&password=password", parsed[1]);
	}

	@Test
	public void parseParam() {
		String paramsEncoded = "userId=javajigi&password=password";
		Map<String, String> params = request.parseParam(paramsEncoded);

		assertEquals(2, params.size());
		assertEquals("javajigi", params.get("userId"));
		assertEquals("password", params.get("password"));
	}

	@Test
	public void parseHeader(){
		String header = "Host: localhost:8080";
		String[] parsed = request.parseHeader(header);
		assertEquals("Host", parsed[0]);
		assertEquals("localhost:8080", parsed[1]);
		assertEquals("localhost:8080", request.getHeader("host"));
	}
	
	
	public void getRequestURI(){
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
