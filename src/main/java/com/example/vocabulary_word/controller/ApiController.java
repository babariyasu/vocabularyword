package com.example.vocabulary_word.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vocabulary_word.dto.WordDto;
import com.example.vocabulary_word.service.WordService;

@Controller
@RestController
@RequestMapping("/api")
public class ApiController {
	private final WordService wordService;
	
	public ApiController(WordService wordService) {
		this.wordService = wordService;
	}
	
	@ResponseBody
	@GetMapping("/vocabulary-books/{bookId}/words")
	public List<WordDto> getWordsByBook(@PathVariable Integer bookId) {
		return wordService.findByVocabularyBookId(bookId)
				.stream()
				.map(WordDto::from)
				.toList();
	}
}
