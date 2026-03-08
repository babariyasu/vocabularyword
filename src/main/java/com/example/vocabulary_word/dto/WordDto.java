package com.example.vocabulary_word.dto;

import com.example.vocabulary_word.entity.Word;

import lombok.Data;

@Data
public class WordDto {
	private Integer id;
	private String name;
	private String meaning;
	
	public WordDto(Integer id, String name, String meaning) {
		this.id = id;
		this.name = name;
		this.meaning = meaning;
	}
	
	public static WordDto from(Word word) {
		return new WordDto(
				word.getId(),
				word.getName(),
				word.getMeaning()
		);
	}
}
	