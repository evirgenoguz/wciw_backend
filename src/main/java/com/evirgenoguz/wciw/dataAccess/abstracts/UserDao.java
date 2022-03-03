package com.evirgenoguz.wciw.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.evirgenoguz.wciw.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	
	
}
