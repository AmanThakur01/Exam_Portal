package com.mycompany.exam.dao;

import java.util.List;

import com.mycompany.exam.domain.Quiz;
import com.mycompany.exam.domain.User;

public interface QuizDao {
	public User save(Quiz q);

	public void update(Quiz q);

	public void delete(Integer qid);

	public User findById(Integer qid);

	public List<User> findAll();

	public List<User> findByProp(String fielName, Object value);
}
