package com.bloggingappapis.repositories;

import com.bloggingappapis.entities.Category;
import com.bloggingappapis.entities.Post;
import com.bloggingappapis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
    List<Post> findByPostTitleContaining(String posttitle);


}
