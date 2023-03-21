package com.bloggingappapis.services;

import com.bloggingappapis.entities.Post;
import com.bloggingappapis.payloads.PostDto;
import com.bloggingappapis.payloads.PostResponse;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface PostService {

    // create post
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // update post
    PostDto updatePost(PostDto postDto, Integer postId);

    // delete post
    void deletePost(Integer postId);

    // get all posts
    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    // get post by post Id
    PostDto getPostById(Integer postId);

    // get all post by category Id
    List<PostDto> getPostsByCategory(Integer categoryId);

    // get all post by user Id
    List<PostDto> getPostByUser(Integer userId);

    // search post by keyword
    List<PostDto> searchPosts(String keyword);

}
