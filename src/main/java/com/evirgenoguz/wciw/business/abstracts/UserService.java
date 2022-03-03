package com.evirgenoguz.wciw.business.abstracts;

import java.util.List;

import com.evirgenoguz.wciw.entities.concretes.User;

public interface UserService {
	List<User> getAll();

	User addUser(User user);
	
	User getUserById(int userId);
	
	User updateUser(int userId, User updatedUser);
	
	void deleteUserbyId(int userId);
}
