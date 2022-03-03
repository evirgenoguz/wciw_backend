package com.evirgenoguz.wciw.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evirgenoguz.wciw.business.abstracts.UserService;
import com.evirgenoguz.wciw.dataAccess.abstracts.UserDao;
import com.evirgenoguz.wciw.entities.concretes.User;


@Service
public class UserManager implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	@Override
	public List<User> getAll() {
		return this.userDao.findAll();
	}

	@Override
	public User addUser(User user) {
		return this.userDao.save(user);
	}

	@Override
	public User getUserById(int userId) {
		return this.userDao.getById(userId);
	}

	@Override
	public User updateUser(int userId, User updatedUser) {
		Optional<User> user = this.userDao.findById(userId);
		
		if(user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(updatedUser.getUserName());
			foundUser.setPassword(updatedUser.getPassword());
			foundUser.setEmail(updatedUser.getEmail());
			this.userDao.save(foundUser);
			return foundUser;
		} else {
			return null;
		}
	}

	@Override
	public void deleteUserbyId(int userId) {
		this.userDao.deleteById(userId);
	}

	
}
