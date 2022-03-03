package com.evirgenoguz.wciw.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evirgenoguz.wciw.entities.concretes.Comment;

public interface CommentDao extends JpaRepository<Comment, Integer> {

}
