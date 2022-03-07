package com.evirgenoguz.wciw.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evirgenoguz.wciw.business.abstracts.UserService;
import com.evirgenoguz.wciw.core.utilities.results.DataResult;
import com.evirgenoguz.wciw.core.utilities.results.ErrorDataResult;
import com.evirgenoguz.wciw.core.utilities.results.Result;
import com.evirgenoguz.wciw.core.utilities.results.SuccessDataResult;
import com.evirgenoguz.wciw.core.utilities.results.SuccessResult;
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
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Kullanıcılar Getirildi");
	}

	@Override
	public DataResult<User> addUser(User user) {
		return new SuccessDataResult<User>(this.userDao.save(user), "Kullanıcı Başarı ile Eklendi");
				
	}

	@Override
	public DataResult<User> getUserById(int userId) {
		return new SuccessDataResult<User>(this.userDao.getById(userId), "Kullanıcı Getirildi");
				
	}

	@Override
	public DataResult<User> updateUser(int userId, User updatedUser) {
		Optional<User> user = this.userDao.findById(userId);
		
		if(user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(updatedUser.getUserName());
			foundUser.setPassword(updatedUser.getPassword());
			foundUser.setEmail(updatedUser.getEmail());
			this.userDao.save(foundUser);
			return new SuccessDataResult<User>(foundUser, "Kullanıcı Başarı ile Güncellendi");
		} else {
			return new ErrorDataResult<User>("Kullanıcı Güncelleme Başarısız");
		}
	}

	@Override
	public Result deleteUserbyId(int userId) {
		this.userDao.deleteById(userId);
		return new SuccessResult("Kullanıcı Silindi");
	}

	
}
