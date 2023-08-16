package com.exam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	
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
