package com.likelion.springbootboard.application.board;

import com.likelion.springbootboard.domain.board.Board;
import com.likelion.springbootboard.domain.board.BoardRepository;
import com.likelion.springbootboard.domain.reply.Reply;
import com.likelion.springbootboard.domain.reply.ReplyRepository;
import com.likelion.springbootboard.dto.reply.ReplyRequest;
import com.likelion.springbootboard.dto.reply.ReplyResponse;
import com.likelion.springbootboard.exception.notfound.BoardNotFoundException;
import com.likelion.springbootboard.exception.notfound.ReplyNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final BoardRepository boardRepository;
    private final ReplyRepository replyRepository;

    public Long saveReply(Long id, ReplyRequest replyRequest) {
        Board board = boardRepository.findById(id).orElseThrow(BoardNotFoundException::new);
        Reply reply = replyRepository.save(replyRequest.toEntity(board));
        return reply.getId();
    }

    public List<ReplyResponse> findAll(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(BoardNotFoundException::new);
        List<Reply> replies = replyRepository.findByBoard(board);
        return replies.stream().map(ReplyResponse::of).collect(Collectors.toList());
    }

    public ReplyResponse findById(Long id) {
        Reply reply = replyRepository.findById(id).orElseThrow(ReplyNotFoundException::new);
        return ReplyResponse.of(reply);
    }

    @Transactional
    public ReplyResponse editReply(Long id, ReplyRequest replyRequest) {
        Reply reply = replyRepository.findById(id).orElseThrow(ReplyNotFoundException::new);
        reply.update(replyRequest.toEntity());
        return ReplyResponse.of(reply);
    }

    public void deleteById(Long id) {
        replyRepository.deleteById(id);
    }
}
