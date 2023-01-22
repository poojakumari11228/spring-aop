package com.lab.lab.dto;

import com.lab.lab.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUserDto {
    long id;
    String title;
    String content;
    String author;
    User user;

}
