package com.synisys.idm.bookstoreservice.domain;

import java.time.LocalDate;

/**
 * @author ashot.karapetyan on 7/27/16.
 */
public class Book {

	private Integer id;
	private String title;
	private String author;


	public Book(Integer id, String title, String author) {
		this.title = title;
		this.author = author;
		this.id = id;
	}

	public Book() {
		this(null, null, null);
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
}

