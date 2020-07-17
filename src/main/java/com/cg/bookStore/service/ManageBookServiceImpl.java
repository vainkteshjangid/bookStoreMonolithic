package com.cg.bookStore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookStore.dao.BookStoreDao;
import com.cg.bookStore.entities.BookInformation;
import com.cg.bookStore.exceptions.BookException;
import com.cg.bookStore.util.BookStoreConstants;

@Service
@Transactional
public class ManageBookServiceImpl implements ManageBookService {

	@Autowired
	private BookStoreDao dao;
	
	@Override
	public String deleteBook(int bookId) throws BookException {
		if(dao.bookExists(bookId)) {
			dao.deleteBook(bookId);
			return BookStoreConstants.BOOK_DELETED;
		}
		throw new BookException(BookStoreConstants.BOOK_DOES_NOT_EXIST);
	}
	
	public String createBook(BookInformation book) throws BookException{
		/*String bookTitle=book.getTitle();
		String bookDesc=book.getDescription();
		String bookAuthor=book.getAuthor();
		String ISBNnum=book.getIsbnNumber();
		
		if(bookTitle.isEmpty()) {
			throw new BookException(BookStoreConstants.BOOK_VALIDATION_TITLE_EMPTY);
		}
		
		if(bookTitle.length()<5 || bookTitle.length()>128) {
			throw new BookException(BookStoreConstants.BOOK_VALIDATION_TITLE);
		}
		
		
		if(bookDesc.isEmpty()) {
			throw new BookException(BookStoreConstants.BOOK_VALIDATION_DESSCRIPTION_EMPTY);
		}
		
		if(bookDesc.length()<200 || bookDesc.length()>2000) {
			throw new BookException(BookStoreConstants.BOOK_VALIDATION_DECRIPTION_);
		}
		
		
		if(bookAuthor.isEmpty()) {
			throw new BookException(BookStoreConstants.BOOK_VALIDATION_AUTHOR_EMPTY);
		}
		
		if(bookAuthor.length()<5 || bookAuthor.length()>65) {
			throw new BookException(BookStoreConstants.BOOK_VALIDATION_AUTHOR_);
		}
		
		
		if(ISBNnum.isEmpty()) {
			8throw new BookException(BookStoreConstants.BOOK_VALIDATION_ISBN_EMPTY);
		}
		
		if(ISBNnum.length()<10 || ISBNnum.length()>15) {
			throw new BookException(BookStoreConstants.BOOK_VALIDATION_ISBN_);
		}
		*/
		if(dao.addBook(book)) {
			return BookStoreConstants.BOOK_ADDED;
		}
		
		return BookStoreConstants.BOOK_ERROR;
		

	}
	
	public String updateBook(BookInformation book) throws BookException{
		if(dao.bookExists(book.getTitle())) {
			throw new BookException(BookStoreConstants.BOOK_EXISTS);
		}
		else {
			if(dao.updateBookInfo(book)) {
				return BookStoreConstants.BOOK_UPDATED;
			}
		}
		throw new BookException(BookStoreConstants.BOOK_ERROR);
	}
	
	public List<BookInformation> displayBooks() throws BookException{
		List<BookInformation>  allBooks= dao.listAllBooks();
		if(allBooks.isEmpty()) {
			throw new BookException(BookStoreConstants.BOOK_DOES_NOT_EXIST);
		}
		
		return allBooks;
			
	}

}
