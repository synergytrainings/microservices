package com.synisys.idm.bookstoreservice.service;

import com.synisys.idm.bookstoreservice.domain.Book;

import java.util.List;

/**
 * @author ashot.karapetyan on 7/27/16.
 */
public interface BookService {


	List<Book> getAllBooks();

	Book getBookById(Integer bookId);

	int saveBook(Book book);
}
