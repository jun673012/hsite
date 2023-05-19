package com.jun.hsite.service;

import com.jun.hsite.domain.Board;
import com.jun.hsite.domain.Comment;
import com.jun.hsite.dto.BoardDto;
import com.jun.hsite.dto.CommentDto;
import com.jun.hsite.repository.BoardRepository;
import com.jun.hsite.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public Long postComment(Long id, CommentDto.Request dto) {
        Board board = boardRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다. " + id));
        dto.setBoard(board);
        Comment comment = dto.toEntity();
        commentRepository.save(comment);
        return comment.getId();
    }

    @Transactional(readOnly = true)
    public List<CommentDto.Response> getAllComment(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: " + id));
        List<Comment> comment = board.getComment();
        return comment.stream().map(CommentDto.Response::new).collect(Collectors.toList());
    }

    @Transactional
    public Long updateComment(Long id, CommentDto.Request dto) {
        Comment comment = commentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. " + id));
        comment.update(dto.getContent());
        return id;
    }

    @Transactional
    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. id=" + id));
        commentRepository.delete(comment);
    }
}
