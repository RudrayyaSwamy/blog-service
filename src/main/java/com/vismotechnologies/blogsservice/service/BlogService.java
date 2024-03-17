package com.vismotechnologies.blogsservice.service;


import com.vismotechnologies.blogsservice.model.Blogs;
import com.vismotechnologies.blogsservice.model.CommentsDetails;
import com.vismotechnologies.blogsservice.model.UserDetailsInfo;
import com.vismotechnologies.blogsservice.repo.BlogRepo;
import com.vismotechnologies.blogsservice.repo.CommentRepo;
import com.vismotechnologies.blogsservice.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BlogService {

    private BlogRepo blogsRepo;
    private UserRepo userRepo;
    private CommentRepo commentRepo;

    public ResponseEntity<Optional<Blogs>> findBlog(Integer blogId) {
        Optional<Blogs> blogs = blogsRepo.findById(blogId);
        return ResponseEntity.ok(blogs);
    }

    public ResponseEntity<List<Blogs>> findAllBlog() {
        return ResponseEntity.ok(blogsRepo.findAll());
    }

    public Blogs saveBlog(Blogs blogs) {
        return blogsRepo.save(blogs);
    }

    public Blogs updateBlog(Blogs blogs) {
      //  Optional<UserDetailsInfo> UserDetailsInfo = userRepo.findById(blogs.getUserId());
        List<CommentsDetails> commentsDetailsEntities = commentRepo.findAllByBlogDetailId(blogs.getBlogId());
      //  UserDetailsInfo.ifPresent(blogs::set);
        if(!commentsDetailsEntities.isEmpty()){
            blogs.setCommentsDetailsByBlogId(commentsDetailsEntities);
        }
        blogs.setUpdatedOn(Timestamp.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))));

        return blogsRepo.save(blogs);
    }

    public void deleteBLog(int id) {
        blogsRepo.deleteById(id);
    }
}
