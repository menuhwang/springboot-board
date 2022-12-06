package com.likelion.springbootboard.domain.reply;

import com.likelion.springbootboard.domain.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByBoard(Board board);
}
