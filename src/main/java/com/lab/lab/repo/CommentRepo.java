package com.lab.lab.repo;

import com.lab.lab.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepo extends JpaRepository<Comment, Long> {
    Optional<Comment> findByIdAndPostIdAndPostUserId(long cid, long pid, long uid);
}
