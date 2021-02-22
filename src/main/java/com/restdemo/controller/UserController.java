package com.restdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restdemo.entities.User;
import com.restdemo.repository.UserRepository;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path = "/test/t", consumes = APPLICATION_JSON_VALUE)
	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findUserById(@PathVariable Long id){
		Optional<User> user = userRepository.findById(id);
		
//		if(user.isPresent()) {
//			return ResponseEntity.status(200).body(user.get());
//		}else {
//			return ResponseEntity.notFound().build();
//		}
		return ResponseEntity.of(user);
		
	}
	
	@PostMapping(path="/post")
	public User saveUser(@Validated @RequestBody User user) {
		System.out.println(user);
		return userRepository.save(user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userRepository.deleteById(id);
	}
}
