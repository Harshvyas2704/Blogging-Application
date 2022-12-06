package com.masai.paylods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
	
	private Integer userId;
	private String userName;
	private String userEmail;
	private String password;
	private String about;

}
