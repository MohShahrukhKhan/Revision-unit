package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

public class GlobalExceptionHandler {
	@ExceptionHandler(TutorialNotFoundException.class)
	public ResponseEntity<MyErrorDetails> bookNotfundHandler(TutorialNotFoundException be, WebRequest wr){
		MyErrorDetails err=new MyErrorDetails();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(be.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> allExceptionHandler(Exception e,WebRequest wr){
        MyErrorDetails err=new MyErrorDetails();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyErrorDetails> wrongURLHandler(NoHandlerFoundException e,WebRequest wr){
        MyErrorDetails err=new MyErrorDetails();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	

}
