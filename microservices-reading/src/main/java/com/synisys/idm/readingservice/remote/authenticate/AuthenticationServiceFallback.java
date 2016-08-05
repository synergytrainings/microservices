package com.synisys.idm.readingservice.remote.authenticate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author ashot.karapetyan on 8/1/16.
 */
public class AuthenticationServiceFallback
		implements AuthenticationServiceFeignClient {

	@Override
	public void authenticateInReadingService() {

	}
}
