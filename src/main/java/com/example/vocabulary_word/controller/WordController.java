package com.example.vocabulary_word.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.vocabulary_word.security.UserDetailsImpl;
import com.example.vocabulary_word.service.VocabularyBookService;
import com.example.vocabulary_word.service.WordService;

@Controller
@RequestMapping("/words")
public class WordController {
	private final VocabularyBookService vocabularyBookService;
	private final WordService wordService;
	
	public WordController(VocabularyBookService vocabularyBookService, WordService wordService) {
		this.vocabularyBookService = vocabularyBookService;
		this.wordService = wordService;
	}

	@PostMapping("/create")
	public String create(@RequestParam Integer vocabularyBookId,
						@RequestParam String name,
						@RequestParam String meaning,
						@AuthenticationPrincipal UserDetailsImpl userDetailsImpl) 
	{
		Integer userId = userDetailsImpl.getUser().getId();
		
		wordService.create(vocabularyBookId, name, meaning, userId);
		
		return "redirect:/vocabulary-books/" + vocabularyBookId;
	}
	
	@PostMapping("/{id}/delete")
	public String delete(@PathVariable Integer id,
						@AuthenticationPrincipal UserDetailsImpl userDetails) 
	{
		Integer userId = userDetails.getUser().getId();
		
		Integer bookId = wordService.delete(id, userId);
		
		return "redirect:/vocabulary-books/" + bookId;
	}
	
	@PostMapping("/{id}/update")
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
