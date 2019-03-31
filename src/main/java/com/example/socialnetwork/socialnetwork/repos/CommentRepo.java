package com.example.socialnetwork.socialnetwork.repos;

import com.example.socialnetwork.socialnetwork.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {

}
