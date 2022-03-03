package com.evirgenoguz.wciw.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evirgenoguz.wciw.business.abstracts.CommentService;
import com.evirgenoguz.wciw.entities.concretes.Comment;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {
	
	private CommentService commentService;

	@Autowired
	public CommentsController(CommentService commentService) {
		super();
		this.commentService = commentService;
	}
	
	@GetMapping("/getall")
	public List<Comment> getAll(){
		return this.commentService.getAll();
	}
	
	@PostMapping
	public Comment addComment(@RequestBody Comment comment) {
		return this.commentService.addComment(comment);
	}
	
	@PutMapping("/updatecomment")
	public Comment updateComment(@PathVariable int commentId, @RequestBody Comment comment){
		return this.commentService.updateComment(commentId, comment);	
	}
	
	@DeleteMapping("/deletecomment")
	public void deleteCommentById(@PathVariable int commentId) {
		this.commentService.deleteCommentbyId(commentId);
	}
}
