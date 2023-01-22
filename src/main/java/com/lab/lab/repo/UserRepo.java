package com.lab.lab.repo;

import com.lab.lab.entity.Post;
import com.lab.lab.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u JOIN FETCH u.posts WHERE SIZE(u.posts) > :n")
    List<User> findUsersWithMoreThanNPost(@Param("n") int n);

    List<User> findAllByPostsTitle(String title);

}
