package com.example.lobosspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lobosspring.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
