package com.masai.servies;

import java.util.List;

import com.masai.payloads.PostDto;
import com.masai.payloads.PostResponse;

public interface PostService {

	// create post

	public PostDto createPost(PostDto postdto, Integer userId, Integer categpryId);

	// update post

	public PostDto updatePost(PostDto postdto, Integer postId);

	// delete post

	public void deletePost(Integer postId);

	// get all post

	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy);

	// get post by postId

	PostDto getPostById(Integer postId);

	// get post by category

	List<PostDto> getPostByCategory(Integer categoryId);

	// get post by users

	List<PostDto> getPostByUser(Integer userId);

	// search post by keyword

	List<PostDto> searchPost(String keyword);

}
