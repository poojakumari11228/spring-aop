package com.lab.lab.service.impl;

import com.lab.lab.Util.Mapper;
import com.lab.lab.entity.User;
import com.lab.lab.repo.UserRepo;
import com.lab.lab.service.PostService;
import com.lab.lab.dto.PostDto;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.lab.lab.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import com.lab.lab.entity.Post;

@Service
@lombok.RequiredArgsConstructor
public class PostServiceImpl implements PostService {


    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<PostDto> findAll() {
        return Mapper.convertPostListToPostDtoList(postRepo.findAll());
    }

    @Override
    public PostDto getById(long id) {
        return modelMapper.map(postRepo.findById(id), new PostDto().getClass());
    }

    @Override
    public void savePost(PostDto postDto) {
        postRepo.save(modelMapper.map(postDto, Post.class));
    }

    @Override
    public void deleteById(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void updateById(long id, PostDto postDto) {
        Optional<Post> post = postRepo.findById(id);
        if (post.isPresent()) {
            Optional<User> user = userRepo.findById(postDto.getUserId());
            Post updatePost = new Post(id, postDto.getTitle(), postDto.getContent(), postDto.getAuthor(), user.get(), Mapper.convertCommentDtoListToCommentList(postDto.getComments(), post.get()));
            postRepo.save(updatePost);
        }
    }

    @Override
    public List<PostDto> findAllWithTitle(String title) {
        System.out.println("***** "+ title);
        return Mapper.convertPostListToPostDtoList(postRepo.findAllByTitle(title));
    }
}
