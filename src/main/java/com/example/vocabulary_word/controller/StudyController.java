package com.example.vocabulary_word.controller;

import org.springframework.stereotype.Controller;

@Controller
public class StudyController {
//	private final VocabularyBookService vocabularyBookService;
//	private final WordService wordService;

//	public StudyController(VocabularyBookService vocabularyBookService, WordService wordService) {
//		this.vocabularyBookService = vocabularyBookService;
//		this.wordService = wordService;
//	}
//
//	@GetMapping("/vocabulary-books/{id}/study")
//	public String study(@PathVariable Integer id, Model model) {
//
//		VocabularyBook vocabularyBook = vocabularyBookService.findById(id);
//
//		model.addAttribute("bookId", id);
//		model.addAttribute("vocabularyBookTitle", vocabularyBook.getTitle());
//
//		return "word/study";
//	}

	//	@GetMapping("/vocabulary-books/")
	//	public String study(@PathVariable Integer id, 
	//						@AuthenticationPrincipal UserDetailsImpl userDetails, 
	//						HttpSession session, 
	//						Model model)
	//	{
	//		Integer userId = userDetails.getUser().getId();
	//		
	//		VocabularyBook book = vocabularyBookService.findByIdAndUserId(id, userId);
	//		
	//		if (book == null) {
	//			return "redirect:/user/home";
	//		}
	//		
	//		if(session.getAttribute("studyWords") == null) {	
	//			List<Word> words = wordService.findByVocabularyBookId(id);
	//			Collections.shuffle(words);
	//			
	//			session.setAttribute("studyWords", words);
	//			session.setAttribute("currentIndex", 0);
	//			session.setAttribute("bookId", id);
	//		}
	//		
	//		List<Word> words = (List<Word>) session.getAttribute("studyWords");
	//		
	//		Integer index = (Integer) session.getAttribute("currentIndex");
	//		
	//		Word currentWord = words.get(index);
	//		
	//		model.addAttribute("word", currentWord);
	//		model.addAttribute("index", index);
	//		model.addAttribute("total", words.size());
	//		
	//		return "word/study";
	//	}

	//修正必要
	//	//次に進む
	//	@PostMapping("/study/next")
	//	public String next(HttpSession session) {
	//		Integer index = (Integer) session.getAttribute("currentIndex");
	//
	//		List<Word> list = (List<Word>) session.getAttribute("studyWords");
	//
	//		if (index < list.size() - 1) {
	//			session.setAttribute("currentIndex", index + 1);
	//		}
	//		
	//		Integer bookId = (Integer) session.getAttribute("bookId");
	//
	//		return "redirect:/vocabulary-books/ + bookId + /study";
	//	}
	//
	//	//前に戻る
	//	@PostMapping("/study/prev")
	//	public String prev(HttpSession session) {
	//
	//		Integer index = (Integer) session.getAttribute("studyWords");
	//
	//		if (index > 0) {
	//			session.setAttribute("currentIndex", index - 1);
	//		}
	//
	//		return "redirect:/vocabulary-books/{id}/study";
	//	}
}
