package com.synisys.idm.readingservice.remote;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.synisys.idm.readingservice.dto.Book;
import com.synisys.idm.readingservice.service.BookRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collections;
import java.util.List;

public class BookRecommendationServiceImpl implements BookRecommendationService {

	private final RestTemplate restTemplate;

	private final String booksStoreUrl;

	@Autowired
	public BookRecommendationServiceImpl(@Value("${remote.booksStore}") String booksStoreUrl, RestTemplate restTemplate){
		this.restTemplate = restTemplate;
		this.booksStoreUrl = booksStoreUrl;
	}

	@Override
	@HystrixCommand(fallbackMethod = "getSampleList", threadPoolKey ="reading-service.loadAllBooks", commandKey = "reading-service.loadAllBooks")
	public List<Book> loadAllBooks() {
		URI uri = URI.create(booksStoreUrl);

		ResponseEntity<List<Book>> booksResponse =
				restTemplate.exchange(uri,
						HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
						});
		List<Book> books = booksResponse.getBody();
		return books;
	}

	public List<Book> getSampleList() {
		return Collections.singletonList(new Book(null, "Cloud Native Java (O'Reilly)", "Josh Long"));
	}

}
