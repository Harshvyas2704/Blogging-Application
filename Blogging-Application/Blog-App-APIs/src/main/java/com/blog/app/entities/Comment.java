package com.blog.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Comment {

	@Id
	private Integer commentId;
	
}
