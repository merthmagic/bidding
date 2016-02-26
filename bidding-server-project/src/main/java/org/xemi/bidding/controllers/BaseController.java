package org.xemi.bidding.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.xemi.bidding.web.WebContext;

public abstract class BaseController {
	protected HttpServletRequest request;  
    protected HttpServletResponse response;  
    protected HttpSession session;  
      
    protected WebContext webContext;
    
    @ModelAttribute  
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){  
        this.request = request;  
        this.response = response;  
        this.session = request.getSession();
        this.webContext = new WebContext(request);
    }
    
    
}
