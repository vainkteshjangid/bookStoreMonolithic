package com.cg.bookStore.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookStore.dao.BookStoreDao;
import com.cg.bookStore.entities.BookInformation;
import com.cg.bookStore.exceptions.BookException;

@Service
@Transactional
public class ManageBookServiceImpl implements ManageBookService {

	@Autowired
	private BookStoreDao dao;
	
	@Override
	public String deleteBook(int bookId) throws BookException {
		if(dao.deleteBook(bookId)) {
			return "Book deleted";
		}
		
		throw new BookException("Book not found");
	}
	
	public String createBook(BookInformation book) throws BookException{
		return "";
	}
	
	public String updateBook(BookInformation book) throws BookException{
		return "";
	}
	
	public String displayBook(int bookId) throws BookException{
		return "";
	}

}
