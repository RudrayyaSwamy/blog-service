package com.vismotechnologies.blogsservice.service;


import com.vismotechnologies.blogsservice.entity.Blogs;
import com.vismotechnologies.blogsservice.entity.CommentsDetails;
import com.vismotechnologies.blogsservice.entity.UserDetailsInfo;
import com.vismotechnologies.blogsservice.model.BlogsModel;
import com.vismotechnologies.blogsservice.model.CommentsDetailsModel;
import com.vismotechnologies.blogsservice.model.UserDetailsInfoModel;
import com.vismotechnologies.blogsservice.repo.BlogRepo;
import com.vismotechnologies.blogsservice.repo.CommentRepo;
import com.vismotechnologies.blogsservice.repo.UserRepo;
import com.vismotechnologies.blogsservice.utils.BlogUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlogService {

    private BlogRepo blogsRepo;
    private UserRepo userRepo;
    private CommentRepo commentRepo;
    private BlogUtils blogUtils;

    public ResponseEntity<Optional<Blogs>> findBlog(Integer blogId) {
        Optional<Blogs> blogs = blogsRepo.findById(blogId);
        return ResponseEntity.ok(blogs);
    }

    public ResponseEntity<List<BlogsModel>> findAllBlog() {
        List<Blogs> blogsList=blogsRepo.findAll();
        List<BlogsModel> blogsModels=blogsList.stream().map(BlogsModel::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(blogsModels);
    }

    public Blogs saveBlog(Blogs blogs) {
        blogs.setCreatedOn(blogUtils.getCurrentTimestamp());
        blogs.setUpdatedOn(blogUtils.getCurrentTimestamp());
        return blogsRepo.save(blogs);
    }

    public Blogs updateBlog(Blogs blogs) {
        Optional<UserDetailsInfo> userInfo = userRepo.findById(blogs.getUserDetailsInfo().getId());
        if(userInfo.isEmpty()){
            throw new UsernameNotFoundException("Please login again");
        };
        userInfo.ifPresent(blogs::setUserDetailsInfo);
        Set<CommentsDetails> commentsDetailsEntities = commentRepo.findAllByBlogDetailId(blogs.getBlogId());
        blogs.setCommentsDetailsByBlogId(commentsDetailsEntities.isEmpty()?blogs.getCommentsDetailsByBlogId():commentsDetailsEntities);
        blogs.setUpdatedOn(Timestamp.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))));

        return blogsRepo.save(blogs);
    }

    public void deleteBLog(int id) {
        blogsRepo.deleteById(id);
    }
}
