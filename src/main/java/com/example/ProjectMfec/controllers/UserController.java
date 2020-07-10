package com.example.ProjectMfec.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjectMfec.UserNotFoundException;
import com.example.ProjectMfec.Model.User;
import com.example.ProjectMfec.Model.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository repo;

	// Get All
	//@GetMapping("/getAllUser")
	@CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/getAllUser")
	public List<User> getAllUser() {

		List<User> userList = repo.getAll();

		for (User user : userList) {

			System.out.print(user.getName());
		}

		return userList;
	}

	// GET ById
//	@GetMapping("/getUserById/{id}")
	
	@CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/getUserById/{id}")
	public List<User> getUserById(@PathVariable long id) {

		List<User> userList = repo.getUserById(id);

		if (userList.isEmpty()) {

			System.out.println("NOT found");
			throw new UserNotFoundException(id);

		} else {
			System.out.println("Account found");
			return userList;

		}
	}
	
	
	// GET ById
	//@GetMapping("/getUserByUsername/{user_username}")
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, path = "/getUserByUsername/{user_username}")
	public List<User> getUserByUsername(@PathVariable String user_username) {

		List<User> userList = repo.getUserByUsername(user_username);

		if (userList.isEmpty()) {

			System.out.println("NOT found");
			throw new UserNotFoundException(user_username);

		} else {
			System.out.println("Account found");
			return userList;

		}
	}
	
	
	
	// POST ADD
	
//	@PostMapping("/addUser")
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin
    @RequestMapping(method = RequestMethod.POST, path = "/addUser")
	public void addUser(@RequestBody User user) {
		System.out.print(user.getAddress());
		this.repo.addUser(user);
	}

	

	
	
	
	//EDIT PROFILE PUT
	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT, path = "/editUserDetail")
	public void editUserDetail(@RequestBody User user) {
		
		
		System.out.print(user.getName());
		repo.editUserDetail(user);

	}

}
