package com.evirgenoguz.wciw.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evirgenoguz.wciw.business.abstracts.PostService;
import com.evirgenoguz.wciw.core.utilities.results.DataResult;
import com.evirgenoguz.wciw.core.utilities.results.ErrorDataResult;
import com.evirgenoguz.wciw.core.utilities.results.ErrorResult;
import com.evirgenoguz.wciw.core.utilities.results.Result;
import com.evirgenoguz.wciw.core.utilities.results.SuccessDataResult;
import com.evirgenoguz.wciw.core.utilities.results.SuccessResult;
import com.evirgenoguz.wciw.dataAccess.abstracts.PostDao;
import com.evirgenoguz.wciw.dataAccess.abstracts.UserDao;
import com.evirgenoguz.wciw.entities.concretes.Post;
import com.evirgenoguz.wciw.entities.concretes.User;
import com.evirgenoguz.wciw.requests.PostCreateRequest;

@Service
public class PostManager implements PostService{

	private PostDao postDao;
	private UserDao userDao;
	
	@Autowired
	public PostManager(PostDao postDao, UserDao userDao) {
		super();
		this.postDao = postDao;
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<Post>> getAll() {
		return new SuccessDataResult<List<Post>>(this.postDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result addPost(PostCreateRequest newPostRequest) {
		
		User user = userDao.getById(newPostRequest.getUserId());

		if (user == null) {
			return new ErrorResult("Kullanıcı Bulunamadı");
		}
		
		Post postToSave = new Post();
		postToSave.setId(newPostRequest.getId());
		postToSave.setDescription(newPostRequest.getDescription());
		postToSave.setTitle(newPostRequest.getTitle());
		postToSave.setUser(user);
		
		
		this.postDao.save(postToSave);
		return new SuccessResult("Post Eklendi");
	}

	@Override
	public DataResult<Post> getPostById(int postId) {
		return new SuccessDataResult<Post>(this.postDao.getById(postId), "Post Getirildi");
	}

	@Override
	public DataResult<Post> updatePost(int postId, Post updatedPost) {
		Optional<Post> post = this.postDao.findById(postId);
		
		if(post.isPresent()) {
			Post foundPost = post.get();
			foundPost.setDescription(updatedPost.getDescription());
			foundPost.setTitle(updatedPost.getTitle());
			this.postDao.save(foundPost);
			return new SuccessDataResult<Post>(foundPost, "Post Güncellendi");
			
		} else {
			return new ErrorDataResult<Post>("Post Güncellenemedi"); //şimdilik böyle kalsın daha sonra ErrorResult dönecek
		}
	}

	@Override
	public Result deletePostbyId(int postId) {
		this.postDao.deleteById(postId);
		return new SuccessResult("Post Başarıyla Silindi");
	}
	
}
