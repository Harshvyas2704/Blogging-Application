package com.bloggingappapis.repositories;

import com.bloggingappapis.entities.Category;
import com.bloggingappapis.payloads.CategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
