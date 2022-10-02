package com.masai.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Book_Id;
	private String name;
	private String author;
	private String publication;
	private String category;
	private int page;
	private double price;
	
	//private List<Book> booksList;
	

	

}
