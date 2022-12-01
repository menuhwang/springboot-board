package com.likelion.springbootboard.presentation.board;

import com.likelion.springbootboard.application.board.BoardService;
import com.likelion.springbootboard.dto.board.BoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("")
    public Long saveBoard(@RequestBody BoardRequest boardRequest) {
        return boardService.saveBoard(boardRequest);
    }
}
