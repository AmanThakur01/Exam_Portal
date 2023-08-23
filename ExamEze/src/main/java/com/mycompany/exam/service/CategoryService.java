package com.mycompany.exam.service;

import java.util.List;

import com.mycompany.exam.domain.Category;

public interface CategoryService {
	/**
	 * add a new Category in application
	 * @param c
	 */
	public Category addCategory(Category c);
	
	/**
	 * this method will edit category in database
	 * @param c updated category
	 * @return
	 */
	public Category updateCategory(Category c);
	
	/**
	 * this method find category by category ID 
	 * @param cid return only one category
	 * @return
	 */
	public Category getCategory(Integer cid);
	
	/**
	 * this method find all category in database
	 * @return return a list of categories
	 */
	public List<Category> getCategories();
	
	/**
	 * this method delete one category from database
	 * @param cid
	 */
	public void deleteCategory(Integer cid);
}
