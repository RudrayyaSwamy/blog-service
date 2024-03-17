package com.vismotechnologies.blogsservice.controller;

import com.vismotechnologies.blogsservice.entity.CommentsDetails;
import com.vismotechnologies.blogsservice.model.CommentsDetailsModel;
import com.vismotechnologies.blogsservice.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@Tag(name="User Comment Controller")
public class CommentController {

    private CommentService commentService;


    @Operation(summary = "This method is used to get the clients.")
    @GetMapping("/comment/findAllCommentsForPost/{blogDetailId}")
    public ResponseEntity<Set<CommentsDetailsModel>> findAllCommentsForPost(@PathVariable int blogDetailId) {
        return commentService.findAllCommentsForPost(blogDetailId);
    }

    @GetMapping("/comment/findAllComments")
    public ResponseEntity<List<CommentsDetailsModel>> findAllComments() {
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
    public ResponseEntity<String> deleteComment(@PathVariable int id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>("Resource deleted successfully", HttpStatus.OK);
    }
}
