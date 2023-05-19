package com.jun.hsite.controller;

import com.jun.hsite.dto.CommentDto;
import com.jun.hsite.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @Operation(summary = "Register the comment", description = "댓글을 등록한다")
    @PostMapping("/board/{id}/comment")
    public ResponseEntity<?> postComment(@PathVariable("id") Long id, @RequestBody CommentDto.Request dto) {
        return new ResponseEntity<>(commentService.postComment(id, dto), HttpStatus.CREATED);
    }

    @Operation(summary = "View all registered comment", description = "모든 댓글을 본다")
    @GetMapping("/board/{id}/comment")
    public ResponseEntity<?> getAllComment(@PathVariable("id") Long id) {
        return new ResponseEntity<>(commentService.getAllComment(id), HttpStatus.OK);
    }

    @Operation(summary = "Modify the comment", description = "댓글을 수정한다")
    @PutMapping("/board/{id}/comment/{id}")
    public ResponseEntity<?> updateComment(@PathVariable("id") Long id, @RequestBody CommentDto.Request dto) {
        return new ResponseEntity<>(commentService.updateComment(id, dto), HttpStatus.OK);
    }

    @Operation(summary = "Delete the comment", description = "댓글을 삭제한다")
    @DeleteMapping("/board/{id}/comment/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable("id") Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
