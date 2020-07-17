package com.cg.bookStore.service;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookStore.dao.BookStoreDao;
import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.exceptions.CategoryException;

@Service
@Transactional
public class ManageCategoryServiceImpl implements ManageCategoryService{

	@Autowired
	private BookStoreDao dao;
	
	@Override
	public String createCategory(BookCategory category) throws CategoryException {
		String categoryName = category.getCategoryName();
		categoryName = categoryName.toLowerCase();
		
		System.out.println(LocalDate.now());
		if(categoryName.isEmpty()) {
			throw new CategoryException("Cannot add empty category");
		}
		
		if(categoryName.length()<5 || categoryName.length()>30) {
			throw new CategoryException("Category name cannot be less than 5 characters and more than 30");
		}
		
		if(dao.categoryExists(categoryName)) {
			throw new CategoryException("Category already exists");
		}
		
		dao.createCategory(category);
		return "Category added";
		
		
	}

	@Override
	public String deleteCategory(int categoryId) throws CategoryException {
		if(dao.categoryExists(categoryId)) {
			dao.deleteCategory(categoryId);
			return "Category deleted";
		}
		throw new CategoryException("Category does not exists");
	}

	@Override
	public String updateCategory(BookCategory category) throws CategoryException {
		
		if(dao.categoryExists(category.getCategoryId())) {
			if(dao.updateCategory(category)) {
				return "Category Updated";
			}
			throw new CategoryException("Category already exists, use another name");
		}
		
		throw new CategoryException("Category Does exist, cannot be updated");
	}



	
}
