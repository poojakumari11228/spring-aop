package com.lab.lab.controller;

import com.lab.lab.aspect.annotation.ExecutionTime;
import com.lab.lab.dto.CommentDto;
import com.lab.lab.dto.PostDto;
import com.lab.lab.dto.UserDto;
import com.lab.lab.dto.UserDtoSimple;
import com.lab.lab.entity.Comment;
import com.lab.lab.entity.User;
import com.lab.lab.service.PostService;
import com.lab.lab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.findUsers();
    }

    @ExecutionTime
    @GetMapping("/{id}")
    public UserDto getUsersById(@PathVariable long id) {
        return userService.findUserById(id);
    }

    @PostMapping
    public void saveUser(@RequestBody UserDtoSimple userDtoSimple){
        userService.saveUser(userDtoSimple);
    }

    @GetMapping("/{id}/posts")
    public List<PostDto> getUsersPost(@PathVariable long id) {
        return userService.getUserPosts(id);
    }
    @GetMapping("/posts/{n}")
    public List<UserDto> getUsersWithMoreThanNPost(@PathVariable int n) {
        return userService.findUsersWithMoreThanNPosts(n);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        userService.deleteById(id);
    }

    @GetMapping("/posts/filter")
    public List<UserDto> getUsersWithPostTitle(@RequestParam String title) {
        return userService.findUsersWithPostTitle(title);
    }

    @GetMapping("/{uid}/posts/{pid}/comments/{cid}")
    public CommentDto getUsersPost(@PathVariable long uid, @PathVariable long pid, @PathVariable long cid) {
        return userService.getUserPostComentsByid(uid, pid, cid);
    }


}
