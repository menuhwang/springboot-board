package com.likelion.springbootboard.presentation.reply;

import com.likelion.springbootboard.application.reply.ReplyService;
import com.likelion.springbootboard.dto.reply.ReplyRequest;
import com.likelion.springbootboard.dto.reply.ReplyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping("/boards/{boardId}/replies")
    public Long saveReply(@PathVariable("boardId") Long boardId, @RequestBody ReplyRequest replyRequest) {
        return replyService.saveReply(boardId, replyRequest);
    }

    @GetMapping("/boards/{boardId}/replies")
    public List<ReplyResponse> findAll(@PathVariable("boardId") Long boardId) {
        return replyService.findAll(boardId);
    }

    @GetMapping("/replies/{id}")
    public ReplyResponse findById (@PathVariable("id") Long id) {
        return replyService.findById(id);
    }

    @PatchMapping("/replies/{id}")
    public ReplyResponse editReply(@PathVariable("id") Long id, @RequestBody ReplyRequest replyRequest) {
        return replyService.editReply(id, replyRequest);
    }

    @DeleteMapping("/replies/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        replyService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
