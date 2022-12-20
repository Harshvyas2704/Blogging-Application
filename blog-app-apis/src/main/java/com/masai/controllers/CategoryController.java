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
import org.springframework.web.bind.annotation.RestController;

import com.masai.payloads.ApiResponse;
import com.masai.payloads.CategoryDto;
import com.masai.servies.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {	
	
	@Autowired
	private CategoryService categoryService;
	
	// Create	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categorydto){
		
		CategoryDto createCategory =  this.categoryService.createCategory(categorydto);
		return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
		
	}
	
	// Update
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categorydto, @PathVariable("catId") Integer catId){
		
		CategoryDto updateCategory =  this.categoryService.updateCategory(categorydto, catId);
		return new ResponseEntity<CategoryDto>(updateCategory, HttpStatus.OK);
		
	}
	
	// delete
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("catId") Integer catId){
		
		this.categoryService.deleteCategory(catId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category is deleted successfully...!", true), HttpStatus.OK);
		
	}
	
	// get
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("catId") Integer catId){
		
		CategoryDto dto = this.categoryService.getCategory(catId);
		
		return new ResponseEntity<CategoryDto>(dto, HttpStatus.OK);
		
	}
	
	// get all
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		
		List<CategoryDto> dtoList = this.categoryService.getCategories();
		
		return new ResponseEntity<List<CategoryDto>>(dtoList, HttpStatus.OK);
		
	}

}
