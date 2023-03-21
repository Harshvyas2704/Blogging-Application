package com.bloggingappapis.services;

import com.bloggingappapis.entities.Category;
import com.bloggingappapis.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    // create
    CategoryDto createCategory(CategoryDto categoryDto);

    // update
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    // delete
    void deleteCategory(Integer categoryId);

    //get by Id
    CategoryDto getCategoryById(Integer categoryId);

    // get all
    List<CategoryDto> getAllCategory();

}
