package com.example.vocabulary_word.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.vocabulary_word.entity.VocabularyBook;
import com.example.vocabulary_word.service.VocabularyBookService;

@Controller
public class ShareController {
	private final VocabularyBookService vocabularyBookService;
	
	public ShareController(VocabularyBookService vocabularyBookService) {
		this.vocabularyBookService = vocabularyBookService;
	}
	
	@GetMapping("/share/{uuid}")
	public String share(@PathVariable String uuid, Model model) {
		VocabularyBook vocabularyBook = vocabularyBookService.findByShareUuid(uuid);
		Integer id = vocabularyBook.getId();
		
		model.addAttribute("bookId", id);
		model.addAttribute("vocabularyBookTitle", vocabularyBook.getTitle());
		
		return "redirect:/vocabulary-books/" + id;
	}

}
