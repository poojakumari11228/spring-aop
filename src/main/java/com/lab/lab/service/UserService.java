package com.lab.lab.service;

import com.lab.lab.dto.CommentDto;
import com.lab.lab.dto.PostDto;
import com.lab.lab.dto.UserDto;
import com.lab.lab.dto.UserDtoSimple;
import com.lab.lab.entity.Comment;
import com.lab.lab.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<UserDto> findUsers();
    UserDto findUserById(long id);

    void saveUser(UserDtoSimple user);

    List<PostDto> getUserPosts(long id);

    List<UserDto> findUsersWithMoreThanNPosts(int n);

    void deleteById(long id);

    List<UserDto> findUsersWithPostTitle(String title);

    CommentDto getUserPostComentsByid(long uid, long pid, long cid);
}
