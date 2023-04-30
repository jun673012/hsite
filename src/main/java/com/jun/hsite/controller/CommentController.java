package com.jun.hsite.controller;

import com.jun.hsite.domain.Comment;
import com.jun.hsite.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/comment/{board_no}")
    public ResponseEntity<?> getComment(@PathVariable("board_no") Long comment_no) {
        return new ResponseEntity<>(commentService.getComment(comment_no), HttpStatus.OK);
    }

    @PostMapping("/comment")
    public ResponseEntity<?> postComment(@RequestBody Comment comment) {
        return new ResponseEntity<>(commentService.postComment(comment), HttpStatus.CREATED);
    }

    @PutMapping("/comment/{comment_no}")
    public ResponseEntity<?> updateComment(@PathVariable Long comment_no, @RequestBody Comment comment) {
        return new ResponseEntity<>(commentService.updateComment(comment_no, comment), HttpStatus.OK);
    }

    @DeleteMapping("/comment/{comment_no}")
    public ResponseEntity<?> deleteComment(@PathVariable("comment_no") Long comment_no) {
        commentService.deleteComment(comment_no);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
