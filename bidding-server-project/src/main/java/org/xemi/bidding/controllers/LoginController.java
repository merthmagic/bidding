package org.xemi.bidding.controllers;

import javax.annotation.Resource;

import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.lang.JoseException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xemi.bidding.models.LoginModel;

@RestController
public class LoginController extends BaseController {
	
	@Resource
	private RsaJsonWebKey rsaJsonWebKey;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(@RequestBody LoginModel loginModel) {
		// TODO:hard code here to mock the login process,we are going to replace
		// it with
		// real implementation.
		try{
			if (loginModel.getUserName().equals("Buffett") && loginModel.getPassWord().equals("mypwd")) {
				response.setHeader("Authorization", this.prepareToken());
			}
			else{
				response.setStatus(401);
			}
		}
		catch(JoseException e){
			e.printStackTrace();
			response.setStatus(500);
		}
	}

	private String prepareToken() throws JoseException {
		
		JwtClaims claims = new JwtClaims();
	    claims.setIssuer("Bidding-Server");
	    claims.setAudience("Bidding-Client");
	    claims.setExpirationTimeMinutesInTheFuture(10); 
	    claims.setGeneratedJwtId(); 
	    claims.setIssuedAtToNow();  
	    claims.setNotBeforeMinutesInThePast(2);

	    JsonWebSignature jws = new JsonWebSignature();

	    jws.setPayload(claims.toJson());

	    jws.setKey(rsaJsonWebKey.getPrivateKey());

	    jws.setKeyIdHeaderValue(rsaJsonWebKey.getKeyId());

	    jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);

	    String jwt = jws.getCompactSerialization();
	    
	    return jwt;
	}
}
