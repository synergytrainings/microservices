package com.synisys.idm.readingservice.endpoint.controller;

import com.google.common.base.Strings;
import com.synisys.idm.readingservice.dto.Book;
import com.synisys.idm.readingservice.service.AuthenticationService;
import com.synisys.idm.readingservice.service.BookRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ashot.karapetyan on 7/24/16.
 */
@RestController
@RequestMapping("/")
public class ReadingController {

	private final BookRecommendationService bookService;
	private final AuthenticationService authenticationService;
	private final Tracer tracer;

	@Autowired
	public ReadingController(BookRecommendationService bookService, AuthenticationService authenticationService, Tracer tracer) {
		this.bookService = bookService;
		this.authenticationService = authenticationService;
		this.tracer = tracer;
	}

	@RequestMapping("to-read")
	public List<String> toRead(@RequestParam(required = false, value = "tag") String tag) {
		this.authenticationService.authenticateInReadingService();
		List<Book> allBooks = bookService.loadAllBooks();
		List<Book> recommended = allBooks;
		if (!Strings.isNullOrEmpty(tag)){
			recommended = allBooks.stream().filter(b->b.getTitle().contains(tag)).collect(Collectors.toList());
		}
		return recommended.stream().map(Book::getTitle).collect(Collectors.toList());
	}
}
