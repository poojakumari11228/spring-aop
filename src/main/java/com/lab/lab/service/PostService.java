package com.lab.lab.service;

import com.lab.lab.dto.PostDto;
import java.util.List;
public interface PostService {
    List<PostDto> findAll();

    PostDto getById(long id);

    void savePost(PostDto postDto);

    void deleteById(long id);

    void updateById(long id, PostDto postDto);

    List<PostDto> findAllWithTitle(String title);
}
