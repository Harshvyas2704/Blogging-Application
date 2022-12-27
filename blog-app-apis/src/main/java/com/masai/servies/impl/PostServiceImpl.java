package com.masai.servies.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.entities.Category;
import com.masai.entities.Post;
import com.masai.entities.User;
import com.masai.exceptions.ResourceNotFoundException;
import com.masai.payloads.PostDto;
import com.masai.payloads.PostResponse;
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
	public PostDto updatePost(PostDto postdto, Integer postId) {
		
		Post post = this.postRepo.findById(postId).
				orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
		
		post.setTitle(postdto.getTitle());
		post.setContent(postdto.getContent());
		post.setImageName(postdto.getImageName());
		
		Post updatedPost = this.postRepo.save(post);
		
		return this.modelMapper.map(updatedPost, PostDto.class);
		
	}

	@Override
	public void deletePost(Integer postId) {
		Post post = this.postRepo.findById(postId).
				orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
		
		this.postRepo.delete(post);
	}

	@Override
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy) {

		
		Pageable p = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
		
		Page<Post> pagepost = this.postRepo.findAll(p); // this is findAl pagable method
		List<Post> allPost = pagepost.getContent();
		
		List<PostDto> postDtos = allPost.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(postDtos);
		postResponse.setPageNumber(pagepost.getNumber());
		postResponse.setPageSize(pagepost.getSize());
		postResponse.setTotleElements(pagepost.getTotalElements());
		postResponse.setTotalPages(pagepost.getTotalPages());
		postResponse.setLastPage(pagepost.isLast());
		
		return postResponse;
		
	}

	@Override
	public PostDto getPostById(Integer postId) {
		
		
		Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post id", postId));
		
		return this.modelMapper.map(post, PostDto.class);
		
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		
		// pagination pending
		
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
		
		List<Post> posts =  this.postRepo.findByCategory(cat);
		
		List<PostDto> postdtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return postdtos;
		
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		
		// pagination pending
		
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User id", userId));
		
		List<Post> posts = this.postRepo.findByUser(user);
		
		List<PostDto> postdtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return postdtos;
		
	}

	@Override
	public List<PostDto> searchPost(String keyword) {
		List<Post> posts =  this.postRepo.findByTitleContaining(keyword);
		
		List<PostDto> postdtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return postdtos;
	}

}
