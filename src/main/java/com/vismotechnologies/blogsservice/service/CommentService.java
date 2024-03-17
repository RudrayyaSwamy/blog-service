package com.vismotechnologies.blogsservice.service;


import com.vismotechnologies.blogsservice.model.CommentsDetails;
import com.vismotechnologies.blogsservice.repo.CommentRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {

    private CommentRepo commentRepo;

    @GetMapping("/comment/findAllCommentsForPost/{blogsByBlogDetailId}")
    public ResponseEntity<List<CommentsDetails>> findAllCommentsForPost(int blogDetailId) {
        List<CommentsDetails>  commentsList= commentRepo.findAllByBlogDetailId(blogDetailId);
        return ResponseEntity.ok(commentsList);
    }

    @GetMapping("/comment/findAllComments")
    public ResponseEntity<List<CommentsDetails>> findAllComments() {
        return ResponseEntity.ok(commentRepo.findAll());
    }

    @PostMapping("/comment/saveComment")
    public CommentsDetails saveComment(@RequestBody CommentsDetails commentsDetails) {
        commentsDetails.setCommentOn(Timestamp.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))));
        return commentRepo.save(commentsDetails);
    }

    @PutMapping("/comment/updateComment")
    public CommentsDetails updateComment(@RequestBody CommentsDetails commentsDetails) {
        commentsDetails.setCommentOn(Timestamp.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))));
        return commentRepo.save(commentsDetails);
    }
    @DeleteMapping("/comment/deleteComment/{id}")
    public void deleteComment(@PathVariable int id) {
        commentRepo.deleteById(id);
    }
}
