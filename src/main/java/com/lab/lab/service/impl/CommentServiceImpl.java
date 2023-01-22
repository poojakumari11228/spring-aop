package com.lab.lab.service.impl;

import com.lab.lab.Util.Mapper;
import com.lab.lab.dto.CommentDto;
import com.lab.lab.repo.CommentRepo;
import com.lab.lab.repo.PostRepo;
import com.lab.lab.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {


    private final CommentRepo commentRepo;
    private final PostRepo postRepo;
    @Autowired
    CommentServiceImpl(CommentRepo commentRepo, PostRepo postRepo, CommentRepo commentRepo1, PostRepo postRepo1){

        this.commentRepo = commentRepo1;
        this.postRepo = postRepo1;
    }

    @Override
    public List<CommentDto> getComments() {
        return Mapper.convertCommentListToCommentDtoList(commentRepo.findAll());
    }

    @Override
    public void addComment(CommentDto commentDto) {
        var post = postRepo.findById(commentDto.getPostId());
        if (post.isPresent())
            commentRepo.save(Mapper.convertCommentDtoToComment(commentDto, post.get()));
    }

    @Override
    public void deleteCommentById(long id) {
        commentRepo.deleteById(id);
    }
}
