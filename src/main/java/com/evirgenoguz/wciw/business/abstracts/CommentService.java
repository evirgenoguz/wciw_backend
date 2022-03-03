package com.evirgenoguz.wciw.business.abstracts;

import java.util.List;

import com.evirgenoguz.wciw.entities.concretes.Comment;


public interface CommentService {
	List<Comment> getAll();
	
	Comment addComment(Comment comment);
	
	Comment getCommentById(int commentId);
	
	Comment updateComment(int commentId, Comment updatedcomment);
	
	void deleteCommentbyId(int commentId);
}

