package com.example.vocabulary_word.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.vocabulary_word.entity.VocabularyBook;
import com.example.vocabulary_word.entity.Word;
import com.example.vocabulary_word.repository.VocabularyBookRepository;
import com.example.vocabulary_word.repository.WordRepository;

@Service
public class WordService {
	private final WordRepository wordRepository;
	private final VocabularyBookRepository vocabularyBookRepository;
	
	public WordService(WordRepository wordRepository, VocabularyBookRepository vocabularyBookRepository) {
		this.wordRepository = wordRepository;
		this.vocabularyBookRepository = vocabularyBookRepository;
	}
	
	public List<Word> findAll() {
		return wordRepository.findAll();
	}
	
	public List<Word> findByVocabularyBookId(Integer vocabularyBookId) {
		return wordRepository.findByVocabularyBookIdOrderByIdDesc(vocabularyBookId);
	}
	
	@Transactional
	public void create(Integer bookId, String name, String meaning, Integer userId) {
		VocabularyBook book = vocabularyBookRepository.findByIdAndUserId(bookId, userId).orElseThrow();
		
		Word word = new Word();
		word.setName(name);
		word.setMeaning(meaning);
		word.setVocabularyBook(book);
		
		wordRepository.save(word);
	}
	
	@Transactional
	public Integer delete(Integer wordId, Integer userId) {
		Word word = wordRepository.findByIdAndVocabularyBook_User_Id(wordId, userId).orElseThrow();
		
		Integer bookId = word.getVocabularyBook().getId();
		
		wordRepository.delete(word);
		
		return bookId;
	}
	
	@Transactional
	public Integer update(Integer wordId, String name, String meaning, Integer userId) {
		Word word = wordRepository
				.findByIdAndVocabularyBook_User_Id(wordId, userId).orElseThrow();
		
		word.setName(name);
		word.setMeaning(meaning);
		
		return word.getVocabularyBook().getId();
		
	}
}
