package edu.itstep.blockchain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.itstep.blockchain.domain.User;

import edu.itstep.blockchain.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("user")


public class UserController {
	@Autowired
	UserServiceImpl userService;
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@GetMapping("/test_access")
	public String greeting(Authentication authentication) {

		String userName = authentication.getName();

		return "Spring Security In-memory Authentication Example - Welcome " + userName;
	}

	@PostMapping(value = "/createUser", consumes = "application/json", produces = "application/json")
	public User createUser(@RequestBody User user) {
		return userService.saveUpdateUser(user);
	}

	@Secured({ "ROLE_ROOT","ROLE_ADMIN"})
	@GetMapping("/users")
	
	public ResponseEntity<List<User>> getAllUsers() {
		
		return
				 ResponseEntity.ok().body(userService.getAllUsers());
				
	}

	@PostMapping(value = "/updateUser", consumes = "application/json", produces = "application/json")
	public User updateUser(@RequestBody User user, HttpServletResponse response) {
		response.setHeader("Location",
				ServletUriComponentsBuilder.fromCurrentContextPath().path("/findPerson/" + user.getId()).toUriString());

		return userService.saveUpdateUser(user);
	}
}
