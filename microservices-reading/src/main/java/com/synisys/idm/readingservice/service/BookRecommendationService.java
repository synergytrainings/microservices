package com.synisys.idm.readingservice.service;

import com.synisys.idm.readingservice.dto.Book;

import java.net.URI;
import java.util.List;

/**
 * @author ashot.karapetyan on 7/24/16.
 */
public interface BookRecommendationService {

	List<Book> loadAllBooks();
}
