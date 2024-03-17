package com.vismotechnologies.blogsservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Data
public class Blogs {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "blog_id", nullable = false)
    private int blogId;
    @Basic
    @Column(name = "title", nullable = true, length = 1000)
    private String title;
    @Basic
    @Column(name = "short_description", nullable = true, length = 2000)
    private String shortDescription;
    @Basic
    @Column(name = "body", nullable = true, length = -1)
    private String body;
    @Basic
    @Column(name = "user_id", nullable = true)
    private Integer userId;
    @Basic
    @Column(name = "created_on", nullable = true)
    private Timestamp createdOn;
    @Basic
    @Column(name = "updated_on", nullable = true)
    private Timestamp updatedOn;

    @OneToOne
    @JoinColumn(name = "blog_id", referencedColumnName = "id", nullable = false)
    private UserDetailsInfo userDetailsByBlogId;
    @OneToMany(mappedBy = "blogsByBlogDetailId")
    private Collection<CommentsDetails> commentsDetailsByBlogId;


}
