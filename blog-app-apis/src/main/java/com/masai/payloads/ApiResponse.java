package com.masai.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
	
	private String message;
	private boolean success;
	
	public ApiResponse(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}

	public ApiResponse() {
		super();
	}
	
	

}
