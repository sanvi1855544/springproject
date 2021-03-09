package com.example.lobosspring.service;

import com.example.lobosspring.model.User;

public interface UserService {
	void save(User user);
	User findByUsername(String username);
	Iterable<User> getUsers();
}
