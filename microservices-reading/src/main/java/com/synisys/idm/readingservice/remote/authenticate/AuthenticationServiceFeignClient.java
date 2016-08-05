package com.synisys.idm.readingservice.remote.authenticate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.synisys.idm.readingservice.service.AuthenticationService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ashot.karapetyan on 7/29/16.
 */
@Service
@FeignClient(name = "authenticationService", url = "${remote.authenticationService}", fallback = AuthenticationServiceFallback.class)
public interface AuthenticationServiceFeignClient
		extends AuthenticationService {

	@RequestMapping(method = RequestMethod.GET)
	void authenticateInReadingService();
}
