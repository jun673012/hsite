package com.jun.hsite.repository;

import com.jun.hsite.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
