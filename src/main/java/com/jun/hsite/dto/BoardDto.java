package com.jun.hsite.dto;

import com.jun.hsite.domain.Board;
import lombok.*;


public class BoardDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    @Setter
    public static class Request {
        private Long id;
        private String title;
        private String content;
        private String writer;
        private String createdDate;
        private String modifiedDate;

        public Board toEntity() {
            Board board = Board.builder()
                    .id(id)
                    .title(title)
                    .content(content)
                    .writer(writer)
                    .build();
            return board;
        }
    }

    @Getter
    public static class Response{
        private Long id;
        private String title;
        private String content;
        private String writer;
        private String createdDate;
        private String modifiedDate;

        public Response(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.writer = board.getWriter();
            this.createdDate = board.getCreatedDate();
            this.modifiedDate = board.getModifiedDate();
        }
    }

}
