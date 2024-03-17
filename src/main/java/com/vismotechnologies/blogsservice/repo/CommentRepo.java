package com.vismotechnologies.blogsservice.repo;

import com.vismotechnologies.blogsservice.entity.CommentsDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CommentRepo  extends JpaRepository<CommentsDetails,Integer> {
    Set<CommentsDetails> findAllByBlogDetailId(int blogId);
}
