package com.example.vocabulary_word.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vocabulary_word.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByEmail(String email);

}
