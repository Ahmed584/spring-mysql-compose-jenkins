package com.springbootdev.examples.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdev.examples.entity.User;
import com.springbootdev.examples.repository.UserRepository;

@RestController
//@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@CrossOrigin
	@GetMapping("/users")
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@GetMapping("/user/{id}")
	@ResponseBody
	public User findByUserId(@PathVariable Long id) {
		return userRepository.findOne(id);
	}

	@CrossOrigin
	@DeleteMapping("/deleteUser/{id}")
	public List<User> delete(@PathVariable Long id) {
		userRepository.delete(id);
		return userRepository.findAll();
	}

	@CrossOrigin
	@PostMapping("/user")
	public User create(@RequestBody User user) {
		return userRepository.save(user);
	}

	@CrossOrigin
	@PutMapping("/update")
	public Boolean updateUser(@RequestBody User user) {
		userRepository.save(user);
		return true;
	}

}
