package com.masai.service;

import java.util.List;
import java.util.Optional;

import com.masai.exceptions.BookNotFundException;
import com.masai.model.Book;

public interface BookService {
	public List<Book> getAllBooks();
	public Book getBookById(int Book_Id)throws BookNotFundException;
	public String saveBook(Book book);
	public String deleteBook(int Book_Id)throws BookNotFundException;
	public String updateBook(Book book)throws BookNotFundException;
	
     
}
