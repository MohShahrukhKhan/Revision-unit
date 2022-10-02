package com.masai.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Book;
import com.masai.service.BookService;

@RestController
@RequestMapping("/bookservice")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getAllBooksHandler(){
		
		return bookService.getAllBooks();
	}
	
	
	@GetMapping("/books/{id}")
	public Book getBookHandler(@PathVariable("id") Integer Book_Id ){
		
		return bookService.getBookById(Book_Id);
	}
	
	@PostMapping("/books")
	public ResponseEntity<String> saveBookHandler(@RequestBody Book book) {
		
		return new ResponseEntity<String>(bookService.saveBook(book),HttpStatus.CREATED);
	}
	
	@PutMapping("books/{id}")
	public String updateBookHandler(@PathVariable("id") Integer book_id,@RequestBody Book book) {
		book.setBook_Id(book_id);
		return bookService.updateBook(book);
	}
	
	@DeleteMapping("books/{id}")
	public String deleteBookhandler(@PathVariable("id") Integer book_id) {
		
		return bookService.deleteBook(book_id);
	}
	
	
	

}
