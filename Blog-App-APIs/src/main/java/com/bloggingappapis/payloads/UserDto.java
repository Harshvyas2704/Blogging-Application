package com.bloggingappapis.payloads;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer userId;
    @NotEmpty
    @Size(min = 4, message = "Username must be more then 4 characters...")
    private String name;
    @Email(message = "Email address is not valid...")
    private String email;
    @NotEmpty
    @Size(min = 3, max = 10, message = "Password must be minimum of 3 chars and maximum of 10 chars...")
    private String password;
    @NotEmpty
    private String about;

}
