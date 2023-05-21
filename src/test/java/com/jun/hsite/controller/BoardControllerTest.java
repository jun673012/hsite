package com.jun.hsite.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jun.hsite.domain.Board;
import com.jun.hsite.dto.BoardDto;
import com.jun.hsite.repository.BoardRepository;
import com.jun.hsite.service.BoardService;
import org.aspectj.weaver.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class BoardControllerTest {

    @InjectMocks
    BoardController boardController;

    @Mock
    BoardService boardService;
    @Mock
    BoardRepository boardRepository;

    MockMvc mockMvc;

    @BeforeEach
    void beforeEach() {
        mockMvc = MockMvcBuilders.standaloneSetup(boardController)
                .build();
    }

    @Test
    void getAllBoard() {
    }

    @Test
    void getBoard() {
    }

    @Test
    void postBoard() {
    }

    @Test
    @DisplayName("게시글 수정 테스트")
    void updateBoard() throws Exception{
        // given
        List<MultipartFile> addedImages = new ArrayList<>();
        addedImages.add(new MockMultipartFile("test1", "test1.PNG", MediaType.IMAGE_PNG_VALUE, "test1".getBytes()));
        addedImages.add(new MockMultipartFile("test2", "test2.PNG", MediaType.IMAGE_PNG_VALUE, "test2".getBytes()));
        List<Integer> deletedImages = List.of(1, 2);
        BoardDto.Request req = new BoardDto.Request("title", "content");

        // then
        mockMvc.perform(put("/board/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(req))
                .param("addedImages", addedImages.toString())
                .param("deletedImages", deletedImages.toString()))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void deleteBoard() {
    }
}