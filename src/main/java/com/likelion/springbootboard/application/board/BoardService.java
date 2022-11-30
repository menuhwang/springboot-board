package com.likelion.springbootboard.application.board;

import com.likelion.springbootboard.domain.board.BoardRepository;
import com.likelion.springbootboard.dto.board.BoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Long saveBoard(BoardRequest boardRequest) {
        return boardRepository.save(boardRequest.toEntity()).getId();
    }
}
