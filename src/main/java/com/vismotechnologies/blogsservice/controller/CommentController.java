package com.vismotechnologies.blogsservice.controller;

import com.vismotechnologies.blogsservice.model.CommentsDetails;
import com.vismotechnologies.blogsservice.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class CommentController {

    private CommentService commentService;

    @GetMapping("/comment/findAllCommentsForPost/{blogDetailId}")
    public ResponseEntity<List<CommentsDetails>> findAllCommentsForPost(@PathVariable int blogDetailId) {
        return commentService.findAllCommentsForPost(blogDetailId);
    }

    @GetMapping("/comment/findAllComments")
    public ResponseEntity<List<CommentsDetails>> findAllComments() {
        return commentService.findAllComments();
    }


    @PostMapping("/comment/saveComment")
    public CommentsDetails saveComment(@RequestBody CommentsDetails commentsDetails) {
        return commentService.saveComment(commentsDetails);
    }

    @PutMapping("/comment/updateComment")
    public CommentsDetails updateComment(@RequestBody CommentsDetails commentsDetails) {
        return commentService.updateComment(commentsDetails);
    }

    @DeleteMapping("/comment/deleteComment/{id}")
    public void deleteComment(@PathVariable int id) {
        commentService.deleteComment(id);
    }
}
