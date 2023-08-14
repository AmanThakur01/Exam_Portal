package com.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.domain.User;
import com.exam.service.UserService;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Project is running...");
//		User u = new User();
//		u.setEmail("amanmrthakur@gmail.com");
//		u.setName("Aman Thakur");
//		u.setPhone("1234567890");
//		u.setProfile("/desktop");
//		u.setUserName("thisIsMe");
//		
//		User user = this.userService.register(u);
//		System.out.println(user.getName());
	}

}
