package com.example.vocabulary_word.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.vocabulary_word.entity.User;
import com.example.vocabulary_word.form.SignupForm;
import com.example.vocabulary_word.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Transactional
	public User createUser(SignupForm signupForm) {
		User user = new User();
		
		user.setName(signupForm.getName());
		user.setFurigana(signupForm.getFurigana());
		user.setEmail(signupForm.getEmail());
		user.setPassword(passwordEncoder.encode(signupForm.getPassword()));
		user.setEnabled(true);
		
		return userRepository.save(user);
	}
	
	//メールアドレス確認
	public boolean isEmailRegistered(String email) {
		User user =userRepository.findByEmail(email);
		return user != null;
	}
	
	//パスワード確認
	public boolean isSamePassword(String password, String passwordConfirmation) {
		return password.equals(passwordConfirmation);
	}
}