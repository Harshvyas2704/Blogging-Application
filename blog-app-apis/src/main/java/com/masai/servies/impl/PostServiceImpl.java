package com.masai.servies.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Category;
import com.masai.entities.Post;
import com.masai.entities.User;
import com.masai.exceptions.ResourceNotFoundException;
import com.masai.payloads.PostDto;
import com.masai.repositories.CategoryRepo;
import com.masai.repositories.PostRepo;
import com.masai.repositories.UserRepo;
import com.masai.servies.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public PostDto createPost(PostDto postdto, Integer userId, Integer categpryId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
		
		Category category = this.categoryRepo.findById(categpryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categpryId));
		
		Post post = this.modelMapper.map(postdto, Post.class);
		post.setImageName("deafult.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post newPost = this.postRepo.save(post);
		
		return this.modelMapper.map(newPost, PostDto.class);
		
		
	}

	@Override
	public Post updatePost(PostDto postdto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
