package com.lab.lab.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import com.lab.lab.service.PostService;
import com.lab.lab.dto.PostDto;
import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {


    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public PostDto getById(@PathVariable int id){
        return postService.getById(id);
    }

    @PostMapping
    public void addPost(@RequestBody PostDto postDto){
        postService.savePost(postDto);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id){
        postService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable int id ,@RequestBody PostDto postDto){
        postService.updateById(id, postDto);
    }

    @GetMapping("/filter")
    public List<PostDto> getAllPostsWithTitle(@RequestParam String title){
        return postService.findAllWithTitle(title);
    }


}
