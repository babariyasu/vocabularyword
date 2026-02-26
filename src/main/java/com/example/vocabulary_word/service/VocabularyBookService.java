package com.example.vocabulary_word.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.vocabulary_word.entity.User;
import com.example.vocabulary_word.entity.VocabularyBook;
import com.example.vocabulary_word.repository.UserRepository;
import com.example.vocabulary_word.repository.VocabularyBookRepository;

@Service
public class VocabularyBookService {
	private final VocabularyBookRepository vocabularyBookRepository;
	private final UserRepository userRepository;
	
	public VocabularyBookService(VocabularyBookRepository vocabularyBookRepository, UserRepository userRepository) {
		this.vocabularyBookRepository = vocabularyBookRepository;
		this.userRepository = userRepository;
	}
	
	public List<VocabularyBook> findByUserId(Integer userId) {
		return vocabularyBookRepository.findByUserId(userId);
	}
	
	public void createVocabularyBook(String title, Integer userId) {
		VocabularyBook book = new VocabularyBook();
		book.setTitle(title);
		
		User user = userRepository.findById(userId).orElseThrow();
		book.setUser(user);
		
		vocabularyBookRepository.save(book);
	}
	
	@Transactional
	public void deleteByIdAndUserId(Integer bookId, Integer userId) {
		VocabularyBook vocabularyBook = vocabularyBookRepository
				.findByIdAndUserId(bookId, userId)
				.orElseThrow(() -> new IllegalArgumentException("不正なアクセスです"));
		
		vocabularyBookRepository.delete(vocabularyBook);
	}
	
	@Transactional
	public void updateTitle(Integer id, String title, Integer userId) {
		VocabularyBook book = vocabularyBookRepository.findByIdAndUserId(id, userId).orElseThrow();
		
		book.setTitle(title);
		
		vocabularyBookRepository.save(book);
	}
	
}
