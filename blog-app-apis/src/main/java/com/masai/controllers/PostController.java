package com.masai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.config.AppConstants;
import com.masai.payloads.ApiResponse;
import com.masai.payloads.PostDto;
import com.masai.payloads.PostResponse;
import com.masai.servies.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {

	@Autowired
	private PostService postService;

	// create post

	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {

		PostDto createdPost = this.postService.createPost(postDto, userId, categoryId);

		return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);

	}

	// get by user

	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getAllPostByUser(@PathVariable Integer userId) {

		List<PostDto> postdtos = this.postService.getPostByUser(userId);

		return new ResponseEntity<List<PostDto>>(postdtos, HttpStatus.OK);

	}

	// get by category

	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getAllPostByCategory(@PathVariable Integer categoryId) {

		List<PostDto> postdtos = this.postService.getPostByCategory(categoryId);

		return new ResponseEntity<List<PostDto>>(postdtos, HttpStatus.OK);

	}

	// get all posts
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(

			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir

	) {

		PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize, sortBy);

		return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);

	}

	// get post by postId
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {

		PostDto postdto = this.postService.getPostById(postId);

		return new ResponseEntity<PostDto>(postdto, HttpStatus.OK);

	}

	// update post
	@PutMapping("/post/{postId}")
	public ResponseEntity<PostDto> updatedPost(@RequestBody PostDto postdto, @PathVariable Integer postId) {

		PostDto updatedPost = this.postService.updatePost(postdto, postId);

		return new ResponseEntity<PostDto>(updatedPost, HttpStatus.OK);

	}

	// delete post
	@DeleteMapping("/post/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId) {

		this.postService.deletePost(postId);

		return new ApiResponse("Post deleted successfully...", true);

	}

	// search method
	@GetMapping("/posts/search/{keywords}")
	public ResponseEntity<List<PostDto>> searchPostByTitle(

			@PathVariable("keywords") String keywords) {

		List<PostDto> postdtos = this.postService.searchPost(keywords);

		return new ResponseEntity<List<PostDto>>(postdtos, HttpStatus.OK);

	}

}
