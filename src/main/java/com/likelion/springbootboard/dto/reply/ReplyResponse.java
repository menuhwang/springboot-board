package com.likelion.springbootboard.dto.reply;

import com.likelion.springbootboard.domain.reply.Reply;
import lombok.Getter;

@Getter
public class ReplyResponse {
    private Long id;
    private String author;
    private String content;

    private ReplyResponse(){
    }

    public ReplyResponse(Long id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public static ReplyResponse of(Reply reply) {
        return new ReplyResponse(reply.getId(), reply.getAuthor(), reply.getContent());
    }
}
