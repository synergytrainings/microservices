package com.synisys.idm.readingservice.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ashot.karapetyan on 7/24/16.
 */
//@Service
//@FeignClient(url="${remote.booksStore}")
public interface BookRecommendationServiceFeignClient extends BookRecommendationService {

	@RequestMapping(method = RequestMethod.GET)
	String loadList();
}
