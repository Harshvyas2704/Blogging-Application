package com.blog.app.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class UserDto {
	
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String about;

}
