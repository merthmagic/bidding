package org.xemi.bidding.web;

import javax.servlet.http.HttpServletRequest;

public class WebContext {
	
	private HttpServletRequest underlyingRequest;
	
	private final String TOKEN_HEADER = "bid-token";
	
	public WebContext(HttpServletRequest request){
		this.underlyingRequest = request;
	}
	
	public String getRequestToken(){
		return this.underlyingRequest.getHeader(this.TOKEN_HEADER);
	}
}
