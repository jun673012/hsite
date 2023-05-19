package com.jun.hsite.controller;

import com.jun.hsite.dto.BoardDto;
import com.jun.hsite.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @Operation(summary = "View all registered board", description = "등록한 모든 글을 본다")
    @GetMapping("/board")
    public ResponseEntity<?> getAllBoard() {
        return new ResponseEntity<>(boardService.getAllBoard(), HttpStatus.OK);
    }

    @Operation(summary = "View registered the board", description = "등록한 글을 본다")
    @GetMapping("/board/{id}")
    public ResponseEntity<?> getBoard(@PathVariable("id") Long id) {
        return new ResponseEntity<>(boardService.getBoard(id), HttpStatus.OK);
    }

    @Operation(summary = "Register the board", description = "글을 등록한다")
    @PostMapping("/board")
    public ResponseEntity<?> postBoard(@RequestBody BoardDto.Request dto) {
        return new ResponseEntity<>(boardService.postBoard(dto), HttpStatus.CREATED);
    }

    @Operation(summary = "Modify the board", description = "글을 수정한다")
    @PutMapping("/board/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable Long id, @RequestBody BoardDto.Request dto) {
        return new ResponseEntity<>(boardService.updateBoard(id, dto), HttpStatus.OK);
    }

    @Operation(summary = "Delete the board", description = "글을 삭제한다")
    @DeleteMapping("/board/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
