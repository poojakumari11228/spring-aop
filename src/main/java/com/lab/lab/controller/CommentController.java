package com.lab.lab.controller;

import com.lab.lab.dto.CommentDto;
import com.lab.lab.repo.CommentRepo;
import com.lab.lab.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;
    private final CommentRepo commentRepo;

    @Autowired
    CommentController(CommentService commentService,
                      CommentRepo commentRepo){
        this.commentService = commentService;
        this.commentRepo = commentRepo;
    }

    @PostMapping
    public void addComment(@RequestBody CommentDto commentDto){
        commentService.addComment(commentDto);
    }

    @GetMapping
    public List<CommentDto> getAllComments(){
        return commentService.getComments();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        commentRepo.deleteById(id);
    }

}
