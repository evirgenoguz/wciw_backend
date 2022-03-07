package com.evirgenoguz.wciw.business.abstracts;

import java.util.List;

import com.evirgenoguz.wciw.core.utilities.results.DataResult;
import com.evirgenoguz.wciw.core.utilities.results.Result;
import com.evirgenoguz.wciw.entities.concretes.Post;

public interface PostService {
	DataResult<List<Post>> getAll();
	
	Result addPost(Post post);
	
	DataResult<Post> getPostById(int postId);
	
	DataResult<Post> updatePost(int postId, Post updatedPost);
	
	Result deletePostbyId(int postId);
}
