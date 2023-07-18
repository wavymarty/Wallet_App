package edu.itstep.blockchain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.itstep.blockchain.domain.User;
import edu.itstep.blockchain.service.UserService;
import edu.itstep.blockchain.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class UserController {
	@Autowired
	UserServiceImpl userService;

	@PostMapping(value = "/createUser", consumes = "application/json", produces = "application/json")
	public User createUser(@RequestBody User user) {
		return userService.saveUpdateUser(user);
	}

	@PostMapping(value = "/updateUser", consumes = "application/json", produces = "application/json")
	public User updateUser(@RequestBody User user, HttpServletResponse response) {
		response.setHeader("Location",
				ServletUriComponentsBuilder.fromCurrentContextPath().path("/findPerson/" + user.getId()).toUriString());

		return userService.saveUpdateUser(user);
	}
}
