package com.jun.hsite.service;

import com.jun.hsite.domain.Board;
import com.jun.hsite.dto.BoardDto;
import com.jun.hsite.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<BoardDto.Response> getAllBoard() {
        return boardRepository.findAll()
                .stream()
                .map(BoardDto.Response::new).
                collect(Collectors.toList());
    }

    @Transactional
    public BoardDto.Response getBoard(Long id) {
        Board board = boardRepository.findById(id).get();
        updateViewCount(id);
        return new BoardDto.Response(board);
    }

    @Transactional
    public Long postBoard(BoardDto.Request dto) {
        return boardRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public Long updateBoard(Long id, BoardDto.Request dto) {
        Board board = boardRepository.findById(id).get();
        board.update(dto.getTitle(), dto.getContent());
        return id;
    }

    @Transactional
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public int updateViewCount(Long id) {
        return boardRepository.updateViewCount(id);
    }

}
