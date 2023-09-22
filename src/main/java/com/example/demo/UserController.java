package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	/**
	 * 
	 * @param user
	 */
    @PostMapping
	void saveUser(@RequestBody Users user){
		
		userService.saveUser(user);
		System.out.println("user created "+user.getName());
			System.out.println("user created "+user.getAge());
		}
	
	@GetMapping
	Iterable<Users>getUser(){
		return userService.getAllUsers();
	}
	@DeleteMapping("/{id}")
	void deleteUser(@PathVariable ("id")int id){
		System.out.println(id);
		userService.deleteUser(id);		
	}
}

