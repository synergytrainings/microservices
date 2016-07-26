package com.synisys.idm.readingservice.endpoint.controller;

import com.synisys.idm.readingservice.service.BookRecommendationService;
import com.synisys.idm.readingservice.service.BookRecommendationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ashot.karapetyan on 7/24/16.
 */
@RestController
@RequestMapping("/")
public class ReadingController {


	@Autowired
	private BookRecommendationService bookService;

	@RequestMapping("to-read")
	public String toRead() {
		return bookService.loadList();
	}
}
