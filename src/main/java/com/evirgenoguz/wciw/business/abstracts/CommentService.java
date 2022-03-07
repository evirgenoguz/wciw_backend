package com.evirgenoguz.wciw.business.abstracts;

import java.util.List;

import com.evirgenoguz.wciw.core.utilities.results.DataResult;
import com.evirgenoguz.wciw.core.utilities.results.Result;
import com.evirgenoguz.wciw.entities.concretes.Comment;


public interface CommentService {
	DataResult<List<Comment>> getAll();
	
	DataResult<Comment> addComment(Comment comment);
	
	DataResult<Comment> getCommentById(int commentId);
	
	DataResult<Comment> updateComment(int commentId, Comment updatedcomment);
	
	Result deleteCommentbyId(int commentId);
}

