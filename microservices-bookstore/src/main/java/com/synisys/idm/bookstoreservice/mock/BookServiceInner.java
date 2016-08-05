package com.synisys.idm.bookstoreservice.mock;

import com.synisys.idm.bookstoreservice.domain.Book;
import com.synisys.idm.bookstoreservice.service.BookService;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * Dummy implementation for BookService
 * @author ashot.karapetyan on 7/27/16.
 */
public class BookServiceInner
		implements BookService {

	Map<Integer, Book> books = new ConcurrentHashMap<>();

	protected BookServiceInner(){
		books.put(1, new Book(1, "Spring in Action (Manning)", "Craig Walls"));
		books.put(2, new Book(2, "Cloud Native Java (O'Reilly)", "Josh Long"));
		books.put(3, new Book(3, "Learning Spring Boot (Packt)", "Greg L. Turnquist"));
		books.put(4, new Book(4, "Effective Java", "Joshua Bloch"));
		books.put(5, new Book(5, "Spring Pro", " Chris Schaefer "));
		books.put(6, new Book(6, "Java Core", " Cay S. Horstmann"));
	}

	@Override
	public List<Book> getAllBooks() {
		return new ArrayList<>(books.values());
	}

	@Override
	public Book getBookById(Integer bookId) {
		return books.get(bookId);
	}

	@Override
	public int saveBook(Book book) {
		int id =  (int)LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
		books.putIfAbsent(id, book);
		return id;
	}
}
