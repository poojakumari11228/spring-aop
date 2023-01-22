package com.lab.lab.repo;

import com.lab.lab.dto.PostDto;
import com.lab.lab.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {


    List<Post> findAllByTitle(String title);
}
