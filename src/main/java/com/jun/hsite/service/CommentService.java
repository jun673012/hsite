package com.jun.hsite.service;

import com.jun.hsite.domain.Comment;
import com.jun.hsite.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public Comment getComment(Long comment_no) {
        Comment comment = commentRepository.findById(comment_no).get();
        return comment;
    }

    @Transactional
    public Comment postComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Transactional
    public Comment updateComment(Long comment_no, Comment comment) {
        Comment newComment = commentRepository.findById(comment_no).get();
        newComment.setComment_author(comment.getComment_author());
        newComment.setBoard_no(comment.getBoard_no());
        newComment.setComment_text(comment.getComment_text());
        //newComment.setCreatedDate(comment.getCreatedDate());
        //newComment.setModifiedDate(comment.getModifiedDate());
        return newComment;
    }

    @Transactional
    public void deleteComment(Long comment_no) {
        commentRepository.deleteById(comment_no);
    }

}
