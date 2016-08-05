package com.synisys.idm.readingservice.remote;

import com.synisys.idm.readingservice.dto.Book;
import com.synisys.idm.readingservice.service.BookRecommendationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;

/**
 * @author ashot.karapetyan on 7/24/16.
 */
//@Service
//@FeignClient(url="${remote.booksStore}", fallback = BookRecommendationServiceFeignClient.HystrixClientFallback.class)
public interface BookRecommendationServiceFeignClient
		extends BookRecommendationService {

	@RequestMapping(method = RequestMethod.GET)
	List<Book> loadAllBooks();

	static class HystrixClientFallback
			implements BookRecommendationServiceFeignClient {
		@Override
		public List<Book> loadAllBooks() {
			return Collections.singletonList(new Book(null, "Cloud Native Java (O'Reilly)", "Josh Long"));
		}
	}
}
