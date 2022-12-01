package com.likelion.springbootboard.presentation.board;

import com.likelion.springbootboard.application.board.BoardService;
import com.likelion.springbootboard.exception.ErrorCode;
import com.likelion.springbootboard.exception.notfound.BoardNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BoardController.class)
class BoardControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BoardService boardService;

    @Test
    void 게시물을_찾을_수_없는_경우_BoardNotFoundException() throws Exception {
        Long id = 1L;

        given(boardService.findById(id)).willThrow(new BoardNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/boards/" + id))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value(ErrorCode.BOARD_NOT_FOUND.getHttpStatus().value()))
                .andExpect(jsonPath("$.type").value(ErrorCode.BOARD_NOT_FOUND.getHttpStatus().getReasonPhrase()))
                .andExpect(jsonPath("$.message").value(ErrorCode.BOARD_NOT_FOUND.getMessage()));
        verify(boardService).findById(id);
    }
}