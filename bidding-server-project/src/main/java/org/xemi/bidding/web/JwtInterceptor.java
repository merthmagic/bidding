package org.xemi.bidding.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Service
public class JwtInterceptor implements HandlerInterceptor {

	@Resource
	private RsaJsonWebKey rsaJsonWebKey;
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String jwt = request.getHeader("Authorization");
		boolean ret = false;
		JwtConsumer jwtConsumer = new JwtConsumerBuilder()
	            .setRequireExpirationTime() 
	            .setAllowedClockSkewInSeconds(30) 
	            //.setRequireSubject()
	            .setExpectedIssuer("Bidding-Server") 
	            .setExpectedAudience("Bidding-Client") 
	            .setVerificationKey(rsaJsonWebKey.getKey()) 
	            .build(); 
		try{
			//TODO: the claims should be put into some where to consumed by controllers.
			JwtClaims jwtClaims = jwtConsumer.processToClaims(jwt);
			ret = true;
		}
		catch(InvalidJwtException e){
			response.setStatus(401);
			e.printStackTrace();
		}
		return ret;
	}

}
