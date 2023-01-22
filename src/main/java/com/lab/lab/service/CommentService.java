package com.lab.lab.service;

import com.lab.lab.dto.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> getComments();
    void addComment(CommentDto commentDto);

    void deleteCommentById(long id);
}
