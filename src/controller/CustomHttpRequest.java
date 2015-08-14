package controller;

import java.util.HashMap;
import java.util.Map;

public class CustomHttpRequest {
	String method;
	String uri;
	Map<String, String> params;
	Map<String, String> headers = new HashMap<String, String>();

	public void parseRequestLine(String requestLine) throws Exception {
		String[] parsed = requestLine.split(" ");
		if(parsed.length !=3) 
			throw new Exception("bad Request");
		this.method = parsed[0];
		parseUriLine(parsed[1]);
	}

	private void parseUriLine(String parsed) {
		String[] uriLineParsed = parseUri(parsed);
		this.uri = uriLineParsed[0];
		this.params = parseParam(uriLineParsed[1]);
	}
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(HashMap<String, String> params) {
		this.params = params;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(HashMap<String, String> headers) {
		this.headers = headers;
	}

	public Map<String, String> parseParam(String paramsEncoded) {
		String[] keyvalues = paramsEncoded.split("&");
		HashMap<String, String> params = new HashMap<String, String>();

		for (String keyvalue : keyvalues) {
			String[] tokens = keyvalue.split("=");
			params.put(tokens[0], tokens[1]);
		}
		
		return params;
	}

	public String getParameter(String key) {
		return this.params.get(key);
	}

	public String[] parseHeader(String string) {
		String[] parsed = string.split(": ", 2);
		this.headers.put(parsed[0].toLowerCase(), parsed[1]);
		return parsed;
	}

	public String getHeader(String string) {
		return this.headers.get(string.toLowerCase());
	}

	public String[] parseUri(String line){
		return line.split("\\?", 2);
	}
	
	public String getRequestURI() {
		return this.getUri();
	}
	
}
