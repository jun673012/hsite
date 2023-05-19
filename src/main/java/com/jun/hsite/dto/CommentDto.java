package com.jun.hsite.dto;

import com.jun.hsite.domain.Board;
import com.jun.hsite.domain.Comment;
import lombok.*;

import java.net.ResponseCache;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommentDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        private Long id;
        private String content;
        private String writer;
        private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        private String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        private Board board;

        public Comment toEntity() {
            Comment comment = Comment.builder()
                    .id(id)
                    .content(content)
                    .writer(writer)
                    .createdDate(createdDate)
                    .modifiedDate(modifiedDate)
                    .board(board)
                    .build();
            return comment;
        }
    }

    @Getter
    @RequiredArgsConstructor
    public static class Response {
        private Long id;
        private String content;
        private String writer;
        private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        private String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        private Long boardId;

        public Response(Comment comment) {
            this.id = comment.getId();
            this.content = comment.getContent();
            this.writer = comment.getWriter();
            this.createdDate = comment.getCreatedDate();
            this.modifiedDate = comment.getModifiedDate();
            this.boardId = comment.getBoard().getId();
            }
        }
}

