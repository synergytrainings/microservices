package com.synisys.idm.readingservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
@Service
public class BookRecommendationServiceImpl implements BookRecommendationService{

	@Autowired
	private RestTemplate restTemplate;

	@Value("${remote.booksStore}")
	private String booksStoreUrl;

	@Override
	@HystrixCommand(fallbackMethod = "getSampleList")
	public String loadList() {
		URI uri = URI.create(booksStoreUrl);

		return this.restTemplate.getForObject(uri, String.class);
	}

	public String getSampleList() {
		return "Cloud Native Java (O'Reilly)";
	}

}
