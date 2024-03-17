package com.vismotechnologies.blogsservice.repo;

import com.vismotechnologies.blogsservice.model.CommentsDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo  extends JpaRepository<CommentsDetails,Integer> {
    List<CommentsDetails> findAllByBlogDetailId(int blogId);
}
