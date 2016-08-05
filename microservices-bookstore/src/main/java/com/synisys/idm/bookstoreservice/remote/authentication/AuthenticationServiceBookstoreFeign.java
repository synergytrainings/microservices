package com.synisys.idm.bookstoreservice.remote.authentication;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.synisys.idm.bookstoreservice.service.AuthenticationServiceBookstore;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ashot.karapetyan on 7/29/16.
 */
@Service
@FeignClient(name = "authenticationServiceBookstore", url = "${remote.authenticationService}", fallback = AuthenticationServiceFallback.class)
public interface AuthenticationServiceBookstoreFeign
		extends AuthenticationServiceBookstore {

	@RequestMapping(method = RequestMethod.GET)
	String authenticateInBookStoreService();

}
