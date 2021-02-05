package com.example.lobosspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
	@Autowired
	private UserRepository UserRepos;

	@PostMapping("/registeruser")
	public String AddUser(@RequestParam String Username, @RequestParam String Password) {
		if (UserRepos.findUserByUsername(Username) == null) {
			User NewUser = new User();
			NewUser.setUsername(Username);
			NewUser.setPassword(Password);
			UserRepos.save(NewUser);
			return "Successfully registered the user named '" + Username + "'.";
		} else {
			return "A user with that username already exists!";
		}
	}

	@GetMapping("/getusers")
	public Iterable<User> GetUsers() {
		return UserRepos.findAll();
	}
}
