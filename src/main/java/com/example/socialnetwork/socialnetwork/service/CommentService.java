package com.example.socialnetwork.socialnetwork.service;

import com.example.socialnetwork.socialnetwork.domain.Comment;
import com.example.socialnetwork.socialnetwork.domain.User;
import com.example.socialnetwork.socialnetwork.repos.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepo commentRepo;

    @Autowired
    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    public Comment create(Comment comment, User user) {
        comment.setAuthor(user);
        commentRepo.save(comment);
        return comment;
    }
}
