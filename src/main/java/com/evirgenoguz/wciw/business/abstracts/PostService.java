package com.evirgenoguz.wciw.business.abstracts;

import java.util.List;

import com.evirgenoguz.wciw.entities.concretes.Post;

public interface PostService {
	List<Post> getAll();
	
	Post addPost(Post post);
	
	Post getPostById(int postId);
	
	Post updatePost(int postId, Post updatedPost);
	
	void deletePostbyId(int postId);
}
