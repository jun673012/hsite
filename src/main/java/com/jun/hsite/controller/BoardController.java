package com.jun.hsite.controller;

import com.jun.hsite.dto.BoardDto;
import com.jun.hsite.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public ResponseEntity<?> getAllBoard() {
        return new ResponseEntity<>(boardService.getAllBoard(), HttpStatus.OK);
    }

    @GetMapping("/board/{id}")
    public ResponseEntity<?> getBoard(@PathVariable("id") Long id) {
        return new ResponseEntity<>(boardService.getBoard(id), HttpStatus.OK);
    }

    @PostMapping("/board")
    public ResponseEntity<?> postBoard(@RequestBody BoardDto.Request dto) {
        return new ResponseEntity<>(boardService.postBoard(dto), HttpStatus.CREATED);
    }

    @PutMapping("/board/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable Long id, @RequestBody BoardDto.Request dto) {
        return new ResponseEntity<>(boardService.updateBoard(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
