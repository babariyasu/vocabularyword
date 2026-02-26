package com.example.vocabulary_word.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.vocabulary_word.entity.VocabularyBook;
import com.example.vocabulary_word.security.UserDetailsImpl;
import com.example.vocabulary_word.service.VocabularyBookService;

@Controller
@RequestMapping("/user")
public class UserController {
	private VocabularyBookService vocabularyBookService;
	
	public UserController(VocabularyBookService vocabularyBookService) {
		this.vocabularyBookService = vocabularyBookService;
	}
	
	@GetMapping("/home")
	public String home(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
						Model model) 
	{
		Integer userId = userDetailsImpl.getUser().getId();
		List<VocabularyBook> vocabularyBooks = vocabularyBookService.findByUserId(userId);
		model.addAttribute("vocabularyBooks", vocabularyBooks);
		
		return "user/home";
	}

}
