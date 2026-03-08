package com.example.vocabulary_word.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.vocabulary_word.entity.VocabularyBook;
import com.example.vocabulary_word.entity.Word;
import com.example.vocabulary_word.security.UserDetailsImpl;
import com.example.vocabulary_word.service.VocabularyBookService;
import com.example.vocabulary_word.service.WordService;

@Controller
public class WordController {
	private final VocabularyBookService vocabularyBookService;
	private final WordService wordService;
	
	public WordController(VocabularyBookService vocabularyBookService, WordService wordService) {
		this.vocabularyBookService = vocabularyBookService;
		this.wordService = wordService;
	}
	
	
	@GetMapping("/vocabulary-books/{id}")
	public String listwords(@PathVariable Integer id,
							@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
							Model model) 
	{
		Integer userId = userDetailsImpl.getUser().getId();
		
		VocabularyBook book = vocabularyBookService.findByIdAndUserId(id, userId);
		
		List<Word> words = wordService.findByVocabularyBookId(id);
		
		model.addAttribute("book", book);
		model.addAttribute("words", words);
		
		return "word/list";
	}
	
	@PostMapping("/words/create")
	public String create(@RequestParam Integer vocabularyBookId,
						@RequestParam String name,
						@RequestParam String meaning,
						@AuthenticationPrincipal UserDetailsImpl userDetailsImpl) 
	{
		Integer userId = userDetailsImpl.getUser().getId();
		
		wordService.create(vocabularyBookId, name, meaning, userId);
		
		return "redirect:/vocabulary-books/" + vocabularyBookId;
	}
	
	@PostMapping("/words/{id}/delete")
	public String delete(@PathVariable Integer id,
						@AuthenticationPrincipal UserDetailsImpl userDetails) 
	{
		Integer userId = userDetails.getUser().getId();
		
		Integer bookId = wordService.delete(id, userId);
		
		return "redirect:/vocabulary-books/" + bookId;
	}
	
	@PostMapping("/words/{id}/update")
	public String update(@PathVariable Integer id,
							@RequestParam String name,
							@RequestParam String meaning,
							@AuthenticationPrincipal UserDetailsImpl userDetails)
	{
		Integer userId = userDetails.getUser().getId();
		
		Integer bookId = wordService.update(id, name, meaning, userId);
		
		return "redirect:/vocabulary-books/" + bookId;
	}

}
