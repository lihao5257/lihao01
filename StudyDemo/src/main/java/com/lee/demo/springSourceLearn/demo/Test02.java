package com.lee.demo.springSourceLearn.demo;

import org.springframework.cglib.core.DebuggingClassWriter;

public class Test02 {

	public static void main(String[] args) {      
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\Users\\lihao\\git");
		BookEditImpl bookFacade=new BookEditImpl();
	    BookFacadeCglib  cglib=new BookFacadeCglib();  
		BookEditImpl bookCglib=(BookEditImpl)cglib.getInstance(bookFacade);  
	    bookCglib.addBook();  
	}  
}


