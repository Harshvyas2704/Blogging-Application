package com.masai.servies.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Category;
import com.masai.exceptions.ResourceNotFoundException;
import com.masai.payloads.CategoryDto;
import com.masai.repositories.CategoryRepo;
import com.masai.servies.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryREpo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category cat = this.modelMapper.map(categoryDto, Category.class);
		
		Category addedCat = this.categoryREpo.save(cat);
		
		return this.modelMapper.map(addedCat, CategoryDto.class);
		
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		Category cat = this.categoryREpo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
		
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedCat = this.categoryREpo.save(cat);
		
		return this.modelMapper.map(updatedCat, CategoryDto.class);
		
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		
		Category cat = this.categoryREpo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
		
		this.categoryREpo.delete(cat);
		
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		
		Category cat = this.categoryREpo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
		
		return this.modelMapper.map(cat, CategoryDto.class);
		
	}

	@Override
	public List<CategoryDto> getCategories() {
		
		List<Category> categories = this.categoryREpo.findAll();
		
		List<CategoryDto> dtos =  categories.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		
		return dtos;
		
	}

}
