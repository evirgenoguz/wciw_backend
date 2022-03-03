package com.evirgenoguz.wciw.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evirgenoguz.wciw.business.abstracts.PostService;
import com.evirgenoguz.wciw.entities.concretes.Post;

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
	public List<Post> getAll(){
		return this.postService.getAll();
	}
	
	@PostMapping("/addpost")
	public Post addPost(@RequestBody Post post) {
		return this.postService.addPost(post);
	}
	
	
}
