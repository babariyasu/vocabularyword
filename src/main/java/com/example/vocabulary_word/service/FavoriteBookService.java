package com.example.vocabulary_word.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.vocabulary_word.entity.FavoriteBook;
import com.example.vocabulary_word.entity.User;
import com.example.vocabulary_word.entity.VocabularyBook;
import com.example.vocabulary_word.repository.FavoriteBookRepository;
import com.example.vocabulary_word.repository.UserRepository;
import com.example.vocabulary_word.repository.VocabularyBookRepository;

@Service
public class FavoriteBookService {
	private final FavoriteBookRepository favoriteBookRepository;
	private final UserRepository userRepository;
	private final VocabularyBookRepository vocabularyBookRepository;
	
	public FavoriteBookService(FavoriteBookRepository favoriteBookRepository, 
								UserRepository userRepository,
								VocabularyBookRepository vocabularyBookRepository) {
		this.favoriteBookRepository = favoriteBookRepository;
		this.userRepository = userRepository;
		this.vocabularyBookRepository = vocabularyBookRepository;
	}
	
	@Transactional
	public void toggleFavorite(Integer userId, Integer bookId) {
		if(favoriteBookRepository.findByUserIdAndBookId(userId, bookId).isEmpty()) {
			
			User user = userRepository.findById(userId).orElseThrow();
			VocabularyBook vocabularyBook = vocabularyBookRepository.findById(bookId).orElseThrow();
			
			FavoriteBook favoriteBook = new FavoriteBook();
			favoriteBook.setUser(user);
			favoriteBook.setVocabularyBook(vocabularyBook);
			
			favoriteBookRepository.save(favoriteBook);
		}
	}
}
