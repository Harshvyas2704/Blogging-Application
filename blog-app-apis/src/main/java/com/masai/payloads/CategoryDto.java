package com.masai.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CategoryDto {

	private Integer categoryId;
	
	@NotBlank(message = "Title should not be null")
	@Size(min = 4)
	private String categoryTitle;
	
	@NotBlank
	@Size(max = 10)
	private String categoryDescription;
	
}
