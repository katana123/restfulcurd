package com.katana.restfulcurd.service;

import com.katana.restfulcurd.dao.CommentRepository;
import com.katana.restfulcurd.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }
}
