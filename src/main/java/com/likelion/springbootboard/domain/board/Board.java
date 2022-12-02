package com.likelion.springbootboard.domain.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String content;

    public void update(Board board) {
        updateTitle(board.getTitle());
        updateAuthor(board.getAuthor());
        updateContent(board.getContent());
    }
    private void updateTitle(String title) {
        if (title != null) {
            this.title = title;
        }
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
