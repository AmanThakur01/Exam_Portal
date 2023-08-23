package com.mycompany.exam.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.exam.dao.UserDao;
import com.mycompany.exam.domain.User;
import com.mycompany.exam.service.UserService;

@RestController
//@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserDao userDao;

	@PostMapping(value = { "/user/add" })
	public Boolean register(@RequestBody User user) throws Exception {

		try {
			user.setRole(userService.ROLE_USER);
			user.setLoginStatus(userService.LOGIN_STATUS_ACTIVE);
			userService.register(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Fail to register User.Please try Again");
		}
		return true;
	}

	@DeleteMapping(value = "/admin/user/bulk-delete")
	public String bulkDeleteUser(@RequestParam("uIds") Integer[] userIds) {
		userService.bulkDelete(userIds);
		return "User Deleted sucessfully.";

	}

	@PostMapping("/user/update")
	public void updateUser(@RequestBody User user) throws Exception {
		try {
			this.userService.editProfile(user);
		} catch (Exception e) {
			throw new Exception("Cannot update user.Try Again!");
		}
	}

	@PostMapping(value = { "/login-action" })
	public User loginAction(@RequestParam("userName") String user_name, @RequestParam String password,
			HttpSession session) throws Exception {

		User u = userService.login(user_name, password);

		if (u.getLoginStatus() == userService.LOGIN_STATUS_ACTIVE) {
			// active

			session.setAttribute("userId", u.getUserId());
			session.setAttribute("role", u.getRole());
			session.setAttribute("user", u);

			return u;

		} else {
			// blocked
			throw new Exception("Your Account is blocked,Please contact to admin");
		}

	}
}
