package com.example.lobosspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lobosspring.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
