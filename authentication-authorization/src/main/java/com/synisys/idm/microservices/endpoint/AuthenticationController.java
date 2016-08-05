package com.synisys.idm.microservices.endpoint;

import com.synisys.idm.microservices.authentication.AuthenticationResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ashot.karapetyan on 7/29/16.
 */
@RestController
@RequestMapping("/")
public class AuthenticationController {

//	@RequestMapping("/authenticate")
//	public AuthenticationResult authenticate(AuthenticationToken authenticationToken){
//		return new AuthenticationResult();
//	}

	@RequestMapping("/authenticate")
	public AuthenticationResult authenticate(){
		return new AuthenticationResult("DummyToken");
	}
}
