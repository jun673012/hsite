package com.jun.hsite.controller;

import com.jun.hsite.dto.CommentDto;
import com.jun.hsite.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/board/{id}/comment")
    public ResponseEntity<?> postComment(@PathVariable("id") Long id, @RequestBody CommentDto.Request dto) {
        return new ResponseEntity<>(commentService.postComment(id, dto), HttpStatus.CREATED);
    }

    @GetMapping("/board/{id}/comment")
    public ResponseEntity<?> getAllComment(@PathVariable("id") Long id) {
        return new ResponseEntity<>(commentService.getAllComment(id), HttpStatus.OK);
    }

    @PutMapping("/board/{id}/comment/{id}")
    public ResponseEntity<?> updateComment(@PathVariable("id") Long id, @RequestBody CommentDto.Request dto) {
        return new ResponseEntity<>(commentService.updateComment(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/board/{id}/comment/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable("id") Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
