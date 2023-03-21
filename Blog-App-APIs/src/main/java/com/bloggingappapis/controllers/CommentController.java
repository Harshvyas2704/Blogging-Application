package com.bloggingappapis.controllers;

import com.bloggingappapis.entities.Comment;
import com.bloggingappapis.payloads.ApiResponse;
import com.bloggingappapis.payloads.CommentDto;
import com.bloggingappapis.services.CommentService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable Integer postId){

        CommentDto commentDto1 = this.commentService.addComment(commentDto, postId);
        return new ResponseEntity<CommentDto>(commentDto1, HttpStatus.CREATED);

    }
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){

        this.commentService.deleteComment(commentId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted successfully...", true), HttpStatus.OK);

    }

}
