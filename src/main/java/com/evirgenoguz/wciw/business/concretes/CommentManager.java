package com.evirgenoguz.wciw.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evirgenoguz.wciw.business.abstracts.CommentService;
import com.evirgenoguz.wciw.core.utilities.results.DataResult;
import com.evirgenoguz.wciw.core.utilities.results.ErrorDataResult;
import com.evirgenoguz.wciw.core.utilities.results.Result;
import com.evirgenoguz.wciw.core.utilities.results.SuccessDataResult;
import com.evirgenoguz.wciw.core.utilities.results.SuccessResult;
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
	public DataResult<List<Comment>> getAll() {
		return new SuccessDataResult<List<Comment>>(this.commentDao.findAll(), "Yorumlar Başarı ile Getirildi");
	}

	@Override
	public DataResult<Comment> addComment(Comment comment) {
		return new SuccessDataResult<Comment>(this.commentDao.save(comment), "Yorum Başarı ile Eklendi");
	}

	@Override
	public DataResult<Comment> getCommentById(int commentId) {
		return new SuccessDataResult<Comment>(this.commentDao.getById(commentId), "Yorum Başarı ile Eklendi");
	}

	@Override
	public DataResult<Comment> updateComment(int commentId, Comment updatedcomment) {
		Optional<Comment> comment = this.commentDao.findById(commentId);
		
		if(comment.isPresent()) {
			Comment foundComment = comment.get();
			foundComment.setCommentText(updatedcomment.getCommentText());
			this.commentDao.save(foundComment);
			return new SuccessDataResult<Comment>(foundComment, "Yorum Başarı ile Güncellendi");
		} else {
			return new ErrorDataResult<Comment>("Güncelleme Başarısız"); //Bunun yerine daha sonra ErrorResult dönecek
		}
	}

	@Override
	public Result deleteCommentbyId(int commentId) {
		this.commentDao.deleteById(commentId);
		return new SuccessResult("Yorum Başarı ile Silindi");
	}

}
