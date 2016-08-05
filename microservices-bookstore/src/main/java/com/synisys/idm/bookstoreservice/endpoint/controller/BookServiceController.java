package com.synisys.idm.bookstoreservice.endpoint.controller;

import com.synisys.idm.bookstoreservice.domain.Book;
import com.synisys.idm.bookstoreservice.service.AuthenticationServiceBookstore;
import com.synisys.idm.bookstoreservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ashot.karapetyan on 7/27/16.
 */
@RestController
@RequestMapping("/")
public class BookServiceController {

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthenticationServiceBookstore authenticationServiceBookstore;



	@RequestMapping(value = "")
	public @ResponseBody Collection<Book> getAllBooks(){
		authenticateRequest();
		return bookService.getAllBooks();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public int addNewBook(@RequestBody Book book){
		//curl -H "Content-Type: application/json" -X POST -d '{"title":"xyz","author":"xyz"}' http://localhost:8090/
		authenticateRequest();
		return bookService.saveBook(book);
	}

	@RequestMapping(value = "/{bookId}")
	public Book getBookById(@PathVariable Integer bookId){
		authenticateRequest();
		return bookService.getBookById(bookId);
	}

	private void authenticateRequest(){
		this.authenticationServiceBookstore.authenticateInBookStoreService();
	}




}
