package com.exam.service;

import com.exam.domain.User;

public interface UserService {
	public static final Integer ROLE_ADMIN=1;
	public static final Integer ROLE_USER=2;
	
	
	public static final Integer LOGIN_STATUS_ACTIVE=1;
	public static final Integer LOGIN_STATUS_BLOCK=2;
	/**
	 * This method will register the user
	 * @param u user entity
	 * @return saved user will be returned
	 * @throws Exception user already exist exception is thrown
	 */
	public User register(User u) throws Exception;
	/**
	 * This method find user details by using username
	 * @param userName it is unique value
	 * @return full object of user
	 */
	public User findByUserName(String userName);
	/**
	 * This method delete User record by its userID
	 * @param id primary key
	 */
	public void deleteById(Long id);
	public User update(User user);
}
