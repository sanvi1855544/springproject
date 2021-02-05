package com.example.lobosspring;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findUserByID(Integer ID);
	User findUserByUsername(String Username);
}
