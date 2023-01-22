package com.lab.lab.Util;

import com.lab.lab.dto.CommentDto;
import com.lab.lab.dto.PostDto;
import com.lab.lab.dto.PostUserDto;
import com.lab.lab.dto.UserDto;
import com.lab.lab.entity.Comment;
import com.lab.lab.entity.Post;
import com.lab.lab.entity.User;

import java.util.List;
import java.util.stream.Collectors;


public class Mapper {


    public static List<UserDto> convertUserListToUserDtoList(List<User> users) {
        return users.stream()
                .map(x -> new UserDto(x.getId(), x.getName(), convertPostListToPostDtoList(x.getPosts())))
                .collect(Collectors.toList());

    }

    public static List<PostDto> convertPostListToPostDtoList(List<Post> posts) {
        return posts.stream()
                .map(x -> new PostDto(x.getId(), x.getTitle(), x.getContent(), x.getAuthor(), x.getUser().getId(), convertCommentListToCommentDtoList(x.getComments())))
                .collect(Collectors.toList());

    }

    public static List<PostUserDto> convertPostListToPostUserDtoList(List<Post> posts) {
        return posts.stream()
                .map(x -> new PostUserDto(x.getId(), x.getTitle(), x.getContent(), x.getAuthor(), x.getUser()))
                .collect(Collectors.toList());

    }

    public static List<CommentDto> convertCommentListToCommentDtoList(List<Comment> comments) {
        return comments.stream()
                .map(x-> new CommentDto(x.getId(), x.getName(), x.getText(), x.getPost().getId()))
                .collect(Collectors.toList());
    }

    public static List<Comment> convertCommentDtoListToCommentList(List<CommentDto> comments, Post post) {
        return comments.stream()
                .map(x-> new Comment(x.getId(), x.getName(), x.getText(), post))
                .collect(Collectors.toList());
    }

    public static Comment convertCommentDtoToComment(CommentDto commentDto, Post post){
        return new Comment(commentDto.getId(), commentDto.getName(), commentDto.getText(), post);
    }

    public static CommentDto convertCommentToCommentDto(Comment comments) {
        return new CommentDto(comments.getId(), comments.getName(), comments.getText(), comments.getPost().getId());
    }

}
