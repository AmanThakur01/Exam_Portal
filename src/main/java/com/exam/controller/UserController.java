package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.domain.User;
import com.exam.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/")
	public User register(@RequestBody User user) throws Exception {

		return this.userService.register(user);
	}
//	@GetMapping("/{userName}")
//	public User getUser(@PathVariable("userName") String userName) {
//		return this.userService.findByUserName(userName);
//	}
//	@DeleteMapping("/{userId}")
//	public void deleteUser(@PathVariable("userId") Long userId ) {
//		this.userService.deleteById(userId);
//	}
//	@PostMapping("/update")
//	public User updateUser(@RequestBody User user ) {
//		return this.userService.update(user);
//	}

	@PostMapping(value = { "/login-action" })
	public String loginAction(@RequestParam String userName, @RequestParam String password, Model m,
			HttpSession session) throws Exception {

		User u = userService.login(userName, password);
		if (u == null) {
			m.addAttribute("err", "User Not Exist,Please Enter Vailed User.");
			return "login";// back to login from
		} else {
			if (u.getLoginStatus() == userService.LOGIN_STATUS_ACTIVE) {
				// active

				session.setAttribute("userId", u.getUserId());
				session.setAttribute("role", u.getRole());
				session.setAttribute("user", u);

				if (u.getRole() == userService.ROLE_USER) {
					return "redirect:user/dashboard";
				} else if (u.getRole() == userService.ROLE_ADMIN) {
					return "redirect:admin/dashboard";
				} else {
					m.addAttribute("err", "Unexcepted Role.Please Contact to admin.");
					return "login";// back to login page
				}
			} else {
				// blocked
				m.addAttribute("err", "Your Account is blocked,Please contact to admin");
			}
			return "login";// Dashboard
		}
	}
}
