package com.vismotechnologies.blogsservice.service;


import com.vismotechnologies.blogsservice.entity.CommentsDetails;
import com.vismotechnologies.blogsservice.model.CommentsDetailsModel;
import com.vismotechnologies.blogsservice.repo.CommentRepo;
import com.vismotechnologies.blogsservice.utils.BlogUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentService {

    private CommentRepo commentRepo;
    private BlogUtils blogUtils;

    @GetMapping("/comment/findAllCommentsForPost/{blogsByBlogDetailId}")
    public ResponseEntity<Set<CommentsDetailsModel>> findAllCommentsForPost(int blogDetailId) {
        Set<CommentsDetails> commentsList= commentRepo.findAllByBlogDetailId(blogDetailId);
        return ResponseEntity.ok(commentsList.stream()
                .map(CommentsDetailsModel::new).collect(Collectors.toSet()));
    }

    @GetMapping("/comment/findAllComments")
    public ResponseEntity<List<CommentsDetailsModel>> findAllComments() {
        List<CommentsDetails> commentsDetailsList = commentRepo.findAll();
        return ResponseEntity.ok(commentsDetailsList.stream()
                .map(CommentsDetailsModel::new).collect(Collectors.toList()));
    }

    @PostMapping("/comment/saveComment")
    public CommentsDetails saveComment(@RequestBody CommentsDetails commentsDetails) {
        commentsDetails.setCommentOn(blogUtils.getCurrentTimestamp());
        return commentRepo.save(commentsDetails);
    }

    @PutMapping("/comment/updateComment")
    public CommentsDetails updateComment(@RequestBody CommentsDetails commentsDetails) {
        commentsDetails.setCommentOn(blogUtils.getCurrentTimestamp());
        return commentRepo.save(commentsDetails);
    }
    @DeleteMapping("/comment/deleteComment/{id}")
    public void deleteComment(@PathVariable int id) {
        commentRepo.deleteById(id);
    }
}
