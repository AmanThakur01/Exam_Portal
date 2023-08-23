package com.mycompany.exam.dao;

import java.util.List;

import com.mycompany.exam.domain.User;


public interface UserDao {
	public User save(User u);

	public void update(User u);

	public void delete(Integer uId);

	public User findById(Integer uId);

	public List<User> findAll();

	public List<User> findByProp(String fielName, Object value);

}
