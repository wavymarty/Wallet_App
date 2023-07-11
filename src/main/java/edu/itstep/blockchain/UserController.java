package edu.itstep.blockchain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.itstep.blockchain.domain.User;
import jakarta.servlet.http.HttpServletResponse;
@RestController
public class UserController {
	
	UserService userService;
	@PostMapping(
			  value = "/createUser", consumes = "application/json", produces = "application/json")
			public User createUser(@RequestBody User user) {
			    return userService.saveUpdatePerson(user);
			}

			@PostMapping(
			  value = "/updateUser", consumes = "application/json", produces = "application/json")
			public User updatePerson(@RequestBody User person, HttpServletResponse response) {
			    response.setHeader("Location", ServletUriComponentsBuilder.fromCurrentContextPath()
			      .path("/findPerson/" + person.getId()).toUriString());
			    
			    return userService.saveUpdatePerson(person);
			}
}
