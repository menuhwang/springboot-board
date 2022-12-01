package com.likelion.springbootboard.application.board;

import com.likelion.springbootboard.domain.board.Board;
import com.likelion.springbootboard.domain.board.BoardRepository;
import com.likelion.springbootboard.dto.board.BoardRequest;
import com.likelion.springbootboard.dto.board.BoardResponse;
import com.likelion.springbootboard.exception.notfound.BoardNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Long saveBoard(BoardRequest boardRequest) {
        return boardRepository.save(boardRequest.toEntity()).getId();
    }

    public BoardResponse findById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(BoardNotFoundException::new);
        return BoardResponse.of(board);
    }
}
