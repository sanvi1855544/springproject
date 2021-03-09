package com.example.lobosspring.model;

import lombok.*;
import javax.persistence.*;
import javax.persistence.ElementCollection;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;
	private String password;

	@ElementCollection
	private Map<Long, String> Posts;

	@Transient
	private String passwordConfirm;

	@ManyToMany
	private Set<Role> roles;
}
