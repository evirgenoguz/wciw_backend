package com.evirgenoguz.wciw.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evirgenoguz.wciw.business.abstracts.PostService;
import com.evirgenoguz.wciw.core.utilities.results.DataResult;
import com.evirgenoguz.wciw.core.utilities.results.Result;
import com.evirgenoguz.wciw.entities.concretes.Post;
import com.evirgenoguz.wciw.requests.PostCreateRequest;

@RestController
@RequestMapping("/api/posts")
public class PostsController {
	
	private PostService postService;

	@Autowired
	public PostsController(PostService postService) {
		super();
		this.postService = postService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Post>> getAll(){
		return postService.getAll();
	}
	
	@GetMapping("/{}")
	public DataResult<Post> getPostById(@RequestParam int postId){
		return postService.getPostById(postId);
	}
	
	@PostMapping("/addpost")
	public Result addPost(@RequestBody PostCreateRequest newPostRequest) {
		return this.postService.addPost(newPostRequest);
	}
	
	
}
