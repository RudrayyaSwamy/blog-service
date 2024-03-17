package com.vismotechnologies.blogsservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
@Table(name = "comments_details", schema = "vtbloges", catalog = "")
public class CommentsDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "comment_id", nullable = false)
    private int commentId;
    @Basic
    @Column(name = "comment", nullable = true, length = 2000)
    private String comment;
    @Basic
    @Column(name = "user_id", nullable = true)
    private Integer userId;
    @Basic
    @Column(name = "blog_detail_id", nullable = true)
    private Integer blogDetailId;
    @Basic
    @Column(name = "comment_on", nullable = true)
    private Timestamp commentOn;
    @ManyToOne
    @JoinColumn(name = "user_details_by_user_id", referencedColumnName = "id")
    private UserDetailsInfo userDetailsByUserId;
    @ManyToOne
    @JoinColumn(name = "blogs_by_blog_detailId", referencedColumnName = "blog_id")
    private Blogs blogsByBlogDetailId;

}
