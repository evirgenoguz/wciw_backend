package com.evirgenoguz.wciw.business.abstracts;

import java.util.List;

import com.evirgenoguz.wciw.core.utilities.results.DataResult;
import com.evirgenoguz.wciw.core.utilities.results.Result;
import com.evirgenoguz.wciw.entities.concretes.User;

public interface UserService {
	DataResult<List<User>> getAll();

	DataResult<User> addUser(User user);
	
	DataResult<User> getUserById(int userId);
	
	DataResult<User> updateUser(int userId, User updatedUser);
	
	Result deleteUserbyId(int userId);
}
