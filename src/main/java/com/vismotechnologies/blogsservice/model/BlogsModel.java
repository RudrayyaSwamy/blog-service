package com.vismotechnologies.blogsservice.model;

import com.vismotechnologies.blogsservice.entity.Blogs;
import com.vismotechnologies.blogsservice.entity.CommentsDetails;
import com.vismotechnologies.blogsservice.entity.UserDetailsInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;


@Data
public class BlogsModel {
    private int blogId;
    private String title;
    private String shortDescription;
    private Timestamp updatedOn;
    private UserDetailsInfoModel userDetailsInfoModel;
    private Set<CommentsDetailsModel> commentsDetailsModelSet;

    public BlogsModel(Blogs blogs){
        blogId=blogs.getBlogId();
        title=blogs.getTitle();
        shortDescription=blogs.getShortDescription();
        updatedOn=blogs.getUpdatedOn();
        userDetailsInfoModel= new UserDetailsInfoModel(blogs.getUserDetailsInfo());
        commentsDetailsModelSet = blogs.getCommentsDetailsByBlogId().stream()
                .map(CommentsDetailsModel::new).collect(Collectors.toSet());
    }
}
