package com.evirgenoguz.wciw.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evirgenoguz.wciw.business.abstracts.PostService;
import com.evirgenoguz.wciw.dataAccess.abstracts.PostDao;
import com.evirgenoguz.wciw.entities.concretes.Post;

@Service
public class PostManager implements PostService{

	private PostDao postDao;
	
	@Autowired
	public PostManager(PostDao postDao) {
		super();
		this.postDao = postDao;
	}

	@Override
	public List<Post> getAll() {
		return this.postDao.findAll();
	}

	@Override
	public Post addPost(Post post) {
		return this.postDao.save(post);
	}

	@Override
	public Post getPostById(int postId) {
		return this.postDao.getById(postId);
	}

	@Override
	public Post updatePost(int postId, Post updatedPost) {
		Optional<Post> post = this.postDao.findById(postId);
		
		if(post.isPresent()) {
			Post foundPost = post.get();
			foundPost.setDescription(updatedPost.getDescription());
			foundPost.setTitle(updatedPost.getTitle());
			this.postDao.save(foundPost);
			return foundPost;
			
		} else {
			return null; //şimdilik böyle kalsın daha sonra ErrorResult dönecek
		}
	}

	@Override
	public void deletePostbyId(int postId) {
		this.postDao.deleteById(postId);
		
	}
	
}
