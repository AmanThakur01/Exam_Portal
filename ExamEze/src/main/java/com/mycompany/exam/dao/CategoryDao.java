package com.mycompany.exam.dao;

import java.util.List;

import com.mycompany.exam.domain.Category;
import com.mycompany.exam.domain.User;

public interface CategoryDao {
	public User save(Category c);

	public void update(Category c);

	public void delete(Integer cid);

	public User findById(Integer cid);

	public List<User> findAll();

	public List<User> findByProp(String fielName, Object value);
}
