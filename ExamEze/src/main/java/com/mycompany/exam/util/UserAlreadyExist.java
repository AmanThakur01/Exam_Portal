package com.mycompany.exam.util;

public class UserAlreadyExist extends Exception {
	public UserAlreadyExist() {
		super("User already Exixt in Database.Use another name.");
	}

	public UserAlreadyExist(String msg) {
		super(msg);
	}
}
