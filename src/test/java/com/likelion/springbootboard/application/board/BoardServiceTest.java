package com.likelion.springbootboard.application.board;

import com.likelion.springbootboard.domain.board.Board;
import com.likelion.springbootboard.domain.board.BoardRepository;
import com.likelion.springbootboard.dto.board.BoardRequest;
import com.likelion.springbootboard.exception.notfound.BoardNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BoardServiceTest {
    @Mock
    private BoardRepository boardRepository;

    @InjectMocks
    private BoardService boardService;

    @Test
    void 게시글_저장() {
        final String AUTHOR = "홍길동";
        final String TITLE = "제목입니다.";
        final String CONTENT = "본문입니다.";
        final Long BOARD_ID = 1L;
        // given
        BoardRequest boardRequest = BoardRequest.builder()
                                                .author(AUTHOR)
                                                .title(TITLE)
                                                .content(CONTENT)
                                                .build();

        Board board = Board.builder()
                            .id(BOARD_ID)
                            .author(AUTHOR)
                            .title(TITLE)
                            .content(CONTENT)
                            .build();

        given(boardRepository.save(any(Board.class))).willReturn(board);

        // when
        Long savedBoardId = boardService.saveBoard(boardRequest);

        // then
        assertEquals(BOARD_ID, savedBoardId);
        verify(boardRepository).save(any(Board.class));
    }

    @Test
    void 게시물_아이디로_검색_결과가_없는_경우_BoardNotFoundException() {
        Long id = 1L;

        given(boardRepository.findById(id)).willReturn(Optional.empty());

        assertThrows(BoardNotFoundException.class, () -> boardService.findById(id));
        verify(boardRepository).findById(1L);
    }
}