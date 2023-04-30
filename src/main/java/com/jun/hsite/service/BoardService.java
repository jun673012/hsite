package com.jun.hsite.service;

import com.jun.hsite.domain.Board;
import com.jun.hsite.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<Board> getAllBoard() {
        List<Board> board = boardRepository.findAll();
        return board;
    }

    @Transactional(readOnly = true)
    public Board getBoard(Long id) {
        Board board = boardRepository.findById(id).get();
        return board;
    }

    @Transactional
    public Board postBoard(Board board) {
        return boardRepository.save(board);

    }

    @Transactional
    public Board updateBoard(Long id, Board board) {
        Board newBoard = boardRepository.findById(id).get();
        newBoard.setTitle(board.getTitle());
        newBoard.setContent(board.getContent());
        newBoard.setAuthor(board.getAuthor());
        //newBoard.setCreatedDate(board.getCreatedDate());
        //newBoard.setModifiedDate(board.getModifiedDate());
        return newBoard;
    }

    @Transactional
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

}
