package com.evirgenoguz.wciw.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evirgenoguz.wciw.business.abstracts.CommentService;
import com.evirgenoguz.wciw.dataAccess.abstracts.CommentDao;
import com.evirgenoguz.wciw.entities.concretes.Comment;

@Service
public class CommentManager implements CommentService{

	private CommentDao commentDao;
	
	@Autowired
	public CommentManager(CommentDao commentDao) {
		super();
		this.commentDao = commentDao;
	}

	@Override
	public List<Comment> getAll() {
		return this.commentDao.findAll();
	}

	@Override
	public Comment addComment(Comment comment) {
		return this.commentDao.save(comment);
	}

	@Override
	public Comment getCommentById(int commentId) {
		return this.commentDao.getById(commentId);
	}

	@Override
	public Comment updateComment(int commentId, Comment updatedcomment) {
		Optional<Comment> comment = this.commentDao.findById(commentId);
		
		if(comment.isPresent()) {
			Comment foundComment = comment.get();
			foundComment.setCommentText(updatedcomment.getCommentText());
			this.commentDao.save(foundComment);
			return foundComment;
		} else {
			return null; //Bunun yerine daha sonra ErrorResult dönecek
		}
	}

	@Override
	public void deleteCommentbyId(int commentId) {
		this.commentDao.deleteById(commentId);
	}

}
