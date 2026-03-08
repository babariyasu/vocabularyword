package com.example.vocabulary_word.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vocabulary_word.entity.Word;

public interface WordRepository extends JpaRepository<Word, Integer> {
	List<Word> findByVocabularyBookId(Integer vocabularyBookId);
	
	List<Word> findByVocabularyBookIdOrderByIdDesc(Integer vocabularyBookId);
	
	Optional<Word> findByIdAndVocabularyBook_User_Id(Integer id, Integer userId);

}
