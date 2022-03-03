package com.evirgenoguz.wciw.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evirgenoguz.wciw.entities.concretes.Post;

public interface PostDao extends JpaRepository<Post, Integer> {

}
