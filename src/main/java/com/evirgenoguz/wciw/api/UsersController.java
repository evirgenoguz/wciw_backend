package com.evirgenoguz.wciw.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evirgenoguz.wciw.business.abstracts.UserService;
import com.evirgenoguz.wciw.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	private UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/getall")
	public List<User> getAll() {
		return this.userService.getAll();
	}
	
	@PostMapping("/createuser")
	public User createUser(@RequestBody User user){
		return this.userService.addUser(user);
	}
	
	@PutMapping("/updateuser")
	public User updateUser(@PathVariable int userId, @RequestBody User user) {
		return this.userService.updateUser(userId, user);
	}
	
	@DeleteMapping("/deleteuser")
	public void deleteUserById(@PathVariable int userId) {
		this.userService.deleteUserbyId(userId);
	}
}
