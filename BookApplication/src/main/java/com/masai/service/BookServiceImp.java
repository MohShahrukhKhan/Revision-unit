package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dao.BookDao;
import com.masai.exceptions.BookNotFundException;
import com.masai.model.Book;
@Service
public class BookServiceImp implements BookService{
	
	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<Book> getAllBooks() {
		
		return bookDao.findAll();
	}

	@Override
	public Book getBookById(int Book_Id) throws BookNotFundException{
		
		
		return  bookDao.findById(Book_Id).orElseThrow(()-> new BookNotFundException("Book does Not exist with Book_ID "+Book_Id));
	}

	@Override
	public String saveBook(Book book) {
		// TODO Auto-generated method stub
		String message="Added Book";
		bookDao.save(book);
		return message;
	}

	@Override
	public String deleteBook(int Book_Id)throws BookNotFundException {
		// TODO Auto-generated method stub
		
		Optional<Book> book=bookDao.findById(Book_Id);
		if(book.isPresent()) {
			bookDao.deleteById(Book_Id);
		}else {
			throw new  BookNotFundException("Book not Exits");
		}
		return "Deleted Succesefully!";
	}

	@Override
	public String updateBook(Book book)throws BookNotFundException {
		// TODO Auto-generated method stub
		Optional<Book> opt=bookDao.findById(book.getBook_Id());
		if(opt.isPresent()) {
			bookDao.save(book);
		}else {
			throw new  BookNotFundException("Book not Exits");
		}
		return "Update Succesefully!";
	}

}
