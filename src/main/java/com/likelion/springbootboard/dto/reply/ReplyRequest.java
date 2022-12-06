package com.likelion.springbootboard.dto.reply;

import com.likelion.springbootboard.domain.board.Board;
import com.likelion.springbootboard.domain.reply.Reply;
import lombok.Getter;

@Getter
public class ReplyRequest {
    private String author;
    private String content;

    public Reply toEntity(Board board) {
        return Reply.builder()
                .author(author)
                .content(content)
                .board(board)
                .build();
    }

    public Reply toEntity() {
        return Reply.builder()
                .author(author)
                .content(content)
                .build();
    }
}
