package com.bloggingappapis.services;

import com.bloggingappapis.payloads.CommentDto;

public interface CommentService {
    CommentDto addComment(CommentDto commentDto, Integer postId);
    void deleteComment(Integer commentId);

}
