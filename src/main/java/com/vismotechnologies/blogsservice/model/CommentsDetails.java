package com.vismotechnologies.blogsservice.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
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
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserDetailsInfo userDetailsByUserId;
    @ManyToOne
    @JoinColumn(name = "blog_detail_id_col", referencedColumnName = "blog_id")
    private Blogs blogsByBlogDetailId;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBlogDetailId() {
        return blogDetailId;
    }

    public void setBlogDetailId(Integer blogDetailId) {
        this.blogDetailId = blogDetailId;
    }

    public Timestamp getCommentOn() {
        return commentOn;
    }

    public void setCommentOn(Timestamp commentOn) {
        this.commentOn = commentOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentsDetails that = (CommentsDetails) o;
        return commentId == that.commentId && Objects.equals(comment, that.comment) && Objects.equals(userId, that.userId) && Objects.equals(blogDetailId, that.blogDetailId) && Objects.equals(commentOn, that.commentOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, comment, userId, blogDetailId, commentOn);
    }

    public UserDetailsInfo getUserDetailsByUserId() {
        return userDetailsByUserId;
    }

    public void setUserDetailsByUserId(UserDetailsInfo userDetailsByUserId) {
        this.userDetailsByUserId = userDetailsByUserId;
    }

    public Blogs getBlogsByBlogDetailId() {
        return blogsByBlogDetailId;
    }

    public void setBlogsByBlogDetailId(Blogs blogsByBlogDetailId) {
        this.blogsByBlogDetailId = blogsByBlogDetailId;
    }
}
