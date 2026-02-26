package com.example.vocabulary_word.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.vocabulary_word.entity.VocabularyBook;
import com.example.vocabulary_word.security.UserDetailsImpl;
import com.example.vocabulary_word.service.VocabularyBookService;

@Controller
@RequestMapping("/vocabulary-books")
public class VocabularyBookController {
	private final VocabularyBookService vocabularyBookService;
	
	public VocabularyBookController(VocabularyBookService vocabularyBookService) {
		this.vocabularyBookService = vocabularyBookService;
	}
	
	@GetMapping("/new")
	public String newBook(Model model) {
		model.addAttribute("vocabularyBook", new VocabularyBook());
		return "vocabulary-books/new";
	}
	
	@PostMapping
	public String create(@ModelAttribute VocabularyBook vocabularyBook,
							@AuthenticationPrincipal UserDetailsImpl userDetails) 
	{
		Integer userId = userDetails.getUser().getId();
		
		vocabularyBookService.createVocabularyBook(vocabularyBook.getTitle(), userId);
		
		return "redirect:/user/home";
	}
	
	@PostMapping("/{id}/delete")
	public String delete(@PathVariable Integer id,
							@AuthenticationPrincipal UserDetailsImpl userDetails) {
		 vocabularyBookService.deleteByIdAndUserId(id, userDetails.getUser().getId());
		 
		 return "redirect:/user/home";
	}
	
	@PostMapping("/{id}/update")
	public String update(@PathVariable Integer id,
						@RequestParam String title,
						@AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
		Integer userId = userDetailsImpl.getUser().getId();
		
		vocabularyBookService.updateTitle(id, title, userId);
		
		return "redirect:/user/home";
	}
	
}
