package com.bloggingappapis.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {

    private Integer categoryId;
    @NotBlank
    @Size(min = 3, message = "Title must me minimum of 3 characters...")
    private String categoryTitle;
    @NotBlank
    @Size(min = 5, max = 100, message = "Description must me minimum of 5 characters...")
    private String categoryDescription;

}
