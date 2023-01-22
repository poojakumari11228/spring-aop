package com.lab.lab.service.impl;


import com.lab.lab.Util.Mapper;
import com.lab.lab.dto.CommentDto;
import com.lab.lab.dto.PostDto;
import com.lab.lab.dto.UserDto;
import com.lab.lab.dto.UserDtoSimple;
import com.lab.lab.entity.Comment;
import com.lab.lab.entity.Post;
import com.lab.lab.entity.User;
import com.lab.lab.repo.CommentRepo;
import com.lab.lab.repo.UserRepo;
import com.lab.lab.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private CommentRepo commentRepo;

    @Override
    public List<UserDto> findUsers() {
        List<UserDto> userList = Mapper.convertUserListToUserDtoList(userRepo.findAll());
        return userList;
    }

    @Override
    public UserDto findUserById(long id) {
        return modelMapper.map(userRepo.findById(id).get(), new UserDto().getClass());
    }

    @Override
    public void saveUser(UserDtoSimple userDto) {
        User user = modelMapper.map(userDto, new User().getClass());
        userRepo.save(user);
    }

    @Override
    public List<PostDto> getUserPosts(long id) {
        var user = userRepo.findById(id);
        List<PostDto> postDtos = Mapper.convertPostListToPostDtoList(user.get().getPosts());
        return postDtos;
    }

    @Override
    public List<UserDto> findUsersWithMoreThanNPosts(int n) {
        return Mapper.convertUserListToUserDtoList(userRepo.findUsersWithMoreThanNPost(n));
    }

    @Override
    public void deleteById(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<UserDto> findUsersWithPostTitle(String title) {
        List<User> user = userRepo.findAllByPostsTitle(title);
        return Mapper.convertUserListToUserDtoList(user);
    }

    @Override
    public CommentDto getUserPostComentsByid(long uid, long pid, long cid) {
       Optional<Comment> comment = commentRepo.findByIdAndPostIdAndPostUserId(cid, pid, uid);
       return Mapper.convertCommentToCommentDto(comment.orElse(new Comment()));

    }
}
