
package com.cg.bookStore;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.bookStore.exceptions.BookException;
import com.cg.bookStore.service.ManageBookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteBookTests {
	@Autowired
	private ManageBookService service;
	
	
	@Test
	public void deleteBook() throws BookException
	{
		String expectedValue = "Book Deleted";
		String actualValue= service.deleteBook(1104);
		assertEquals(expectedValue,actualValue);
	}
	@Test
	public void deleteBook1() throws BookException
	{
		String expectedValue = "Book does not exist!";
		String actualValue= service.deleteBook(2);
		assertEquals(expectedValue,actualValue);
	}

}