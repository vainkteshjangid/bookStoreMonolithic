package com.cg.bookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.exceptions.CategoryException;
import com.cg.bookStore.service.ManageCategoryService;

@RestController
public class ManageCategoryController {

	@Autowired
	private ManageCategoryService service;
	
	@PostMapping("/manageCategory/create")
	public String createCategory(@RequestBody BookCategory category) throws CategoryException {
		return service.createCategory(category);
	}
	
	@GetMapping("manageCategory/delete/{categoryId}")
	public String deleteCategory(@PathVariable(name="categoryId") int categoryId) throws CategoryException {
		return service.deleteCategory(categoryId);
	}
	
	@PostMapping("manageCategory/update")
	public String updateCategory(@RequestBody BookCategory category) throws CategoryException {
		return service.updateCategory(category);
	}
	
	@GetMapping("manageCategory/display/{categoryId}")
	public String displayCategory(@PathVariable(name="categoryId") int categoryId) throws CategoryException {
		return service.displayCategory(categoryId);
	}
}
