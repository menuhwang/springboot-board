package com.likelion.springbootboard.domain.reply;

import com.likelion.springbootboard.domain.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String content;
    @ManyToOne
    private Board board;

    @Builder
    public Reply(String author, String content, Board board) {
        this.author = author;
        this.content = content;
        this.board = board;
    }

    public void update(Reply update) {
        updateAuthor(update.getAuthor());
        updateContent(update.getContent());
    }

    private void updateAuthor(String author) {
        if (author != null) {
            this.author = author;
        }
    }

    private void updateContent(String content) {
        if (content != null) {
            this.content = content;
        }
    }
}
