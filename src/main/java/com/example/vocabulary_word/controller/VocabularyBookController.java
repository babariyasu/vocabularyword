package com.example.vocabulary_word.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.vocabulary_word.entity.VocabularyBook;
import com.example.vocabulary_word.entity.Word;
import com.example.vocabulary_word.security.UserDetailsImpl;
import com.example.vocabulary_word.service.VocabularyBookService;
import com.example.vocabulary_word.service.WordService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/vocabulary-books")
public class VocabularyBookController {
	private final VocabularyBookService vocabularyBookService;
	private final WordService wordService;
	
	public VocabularyBookController(VocabularyBookService vocabularyBookService, WordService wordService) {
		this.vocabularyBookService = vocabularyBookService;
		this.wordService = wordService;
	}
	
	@GetMapping("/new")
	public String newBook(Model model) {
		model.addAttribute("vocabularyBook", new VocabularyBook());
		return "vocabulary-books/new";
	}
	
	@PostMapping("/create")
	public String create(@RequestParam String title,
							@AuthenticationPrincipal UserDetailsImpl userDetails) 
	{
		
		Integer userId = userDetails.getUser().getId();
		
		VocabularyBook vocabularyBook = vocabularyBookService.createVocabularyBook(title, userId);
		
		return "redirect:/vocabulary-books/" + vocabularyBook.getId();
	}
	
	@GetMapping("/{id}")
	public String listwords(@PathVariable Integer id,
							@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
							HttpServletRequest request,
							Model model) 
	{
		Integer userId = null;
		
		if (userDetailsImpl != null) {
			userId = userDetailsImpl.getUser().getId();
		}

		VocabularyBook book = vocabularyBookService.findById(id);
		
		String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), "");
		
		String shareUrl = baseUrl + "/share/" + book.getShareUuid();
		
		List<Word> words = wordService.findByVocabularyBookId(id);
		
		model.addAttribute("book", book);
		model.addAttribute("shareUrl", shareUrl);
		model.addAttribute("words", words);
		model.addAttribute("loginUserId", userId);
		
		return "word/list";
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
	
	@GetMapping("/{id}/study")
	public String study(@PathVariable Integer id, Model model) {

		VocabularyBook vocabularyBook = vocabularyBookService.findById(id);

		model.addAttribute("bookId", id);
		model.addAttribute("vocabularyBookTitle", vocabularyBook.getTitle());

		return "word/study";
	}
	
}
