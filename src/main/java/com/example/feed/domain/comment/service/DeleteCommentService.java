package com.example.feed.domain.comment.service;

import com.example.feed.domain.comment.domain.Comment;
import com.example.feed.domain.comment.domain.repository.CommentRepository;
import com.example.feed.domain.comment.facade.CommentFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteCommentService {

    private final CommentFacade commentFacade;
    private final CommentRepository commentRepository;

    public void execute(Long commentId) {
        Comment comment = commentFacade.getComment(commentId);
        commentRepository.delete(comment);
    }
}
