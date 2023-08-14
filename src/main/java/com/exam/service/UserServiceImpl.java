package com.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.domain.User;
import com.exam.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	/**
	 * This method will create new user
	 */
	@Override
	public User register(User u) throws Exception {
		User local = this.userRepo.findByUserName(u.getUserName());
		if (local != null) {
			
			System.out.println("User already exist!!");
			throw new Exception("User already exist!!");
		} else {
			u.setLoginStatus(LOGIN_STATUS_ACTIVE);
			u.setRole(ROLE_USER);
			local = this.userRepo.save(u);
		}
		return local;
	}

	/**
	 * find user by username as a parameter and return user if found
	 */
	@Override
	public User findByUserName(String userName) {

		return this.userRepo.findByUserName(userName);
	}

	/**
	 * this method delete one record by its userID
	 */
	@Override
	public void deleteById(Long id) {
		this.userRepo.deleteById(id);

	}

	@Override
	public User update(User user) {
		
		return this.userRepo.save(user);
	}

}
