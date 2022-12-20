package com.masai.servies;

import java.util.List;

import com.masai.entities.Post;
import com.masai.payloads.PostDto;

public interface PostService {
	
	// create
	
	public PostDto createPost(PostDto postdto, Integer userId, Integer categpryId);
	
	// update
	
	public Post updatePost(PostDto postdto, Integer postId);

	// delete
	
	public void deletePost(Integer postId);
	
	// get all post
	
	List<Post> getAllPost();
	
	// get post by Id
	
	Post getPostById(Integer postId);
	
	// get post by category
	
	List<Post> getPostByCategory(Integer categoryId);
	
	// get post by users
	
	List<Post> getPostByUser(Integer userId);
	
	// search post by keyword
	
	List<Post> searchPost(String keyword);
	
}
