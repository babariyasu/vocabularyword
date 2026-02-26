package com.example.vocabulary_word.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vocabulary_word.entity.VocabularyBook;

public interface VocabularyBookRepository extends JpaRepository<VocabularyBook, Integer> {
	List<VocabularyBook> findByUserId(Integer userId);
	
	Optional<VocabularyBook> findByIdAndUserId(Integer id, Integer userid);
}
