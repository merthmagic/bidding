package org.xemi.bidding;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.xemi.bidding.web.JwtInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Resource
	JwtInterceptor jwtInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(jwtInterceptor).addPathPatterns("/bids/detail/**");
	}
}
