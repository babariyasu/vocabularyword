package com.example.vocabulary_word.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vocabulary_word.entity.Word;

public interface WordRepository extends JpaRepository<Word, Integer> {

}
