package com.example.vocabulary_word.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vocabulary_word.entity.FavoriteBook;

public interface FavoriteBookRepository extends JpaRepository<FavoriteBook, Integer> {
	
	Optional<FavoriteBook> findByUserIdAndBookId(Integer userId, Integer bookId);
	
	List<FavoriteBook> findByUserId(Integer userId);
}
