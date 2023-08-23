package com.mycompany.exam.dao;

import java.util.List;

import com.mycompany.exam.domain.Question;
import com.mycompany.exam.domain.User;

public interface QuestionDao {
	public User save(Question q);

	public void update(Question q);

	public void delete(Integer qid);

	public User findById(Integer qid);

	public List<User> findAll();

	public List<User> findByProp(String fielName, Object value);
}
