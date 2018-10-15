package com.katana.restfulcurd.dao;

import com.katana.restfulcurd.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
