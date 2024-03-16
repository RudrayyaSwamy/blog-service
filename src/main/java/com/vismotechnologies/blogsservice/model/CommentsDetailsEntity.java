package com.vismotechnologies.blogsservice.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "comments_details", schema = "vtbloges", catalog = "")
public class CommentsDetailsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "comment", nullable = true, length = 2000)
    private String comment;
    @Basic
    @Column(name = "user_id", nullable = true)
    private Integer userId;
    @Basic
    @Column(name = "blog_detail_id", nullable = true)
    private Integer blogDetailId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserDetailsEntity userDetailsByUserId;
    @ManyToOne
    @JoinColumn(name = "blog_detail_id", referencedColumnName = "blog_id")
    private BlogsEntity blogsByBlogDetailId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentsDetailsEntity that = (CommentsDetailsEntity) o;
        return id == that.id && Objects.equals(comment, that.comment) && Objects.equals(userId, that.userId) && Objects.equals(blogDetailId, that.blogDetailId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment, userId, blogDetailId);
    }

    public UserDetailsEntity getUserDetailsByUserId() {
        return userDetailsByUserId;
    }

    public void setUserDetailsByUserId(UserDetailsEntity userDetailsByUserId) {
        this.userDetailsByUserId = userDetailsByUserId;
    }

    public BlogsEntity getBlogsByBlogDetailId() {
        return blogsByBlogDetailId;
    }

    public void setBlogsByBlogDetailId(BlogsEntity blogsByBlogDetailId) {
        this.blogsByBlogDetailId = blogsByBlogDetailId;
    }
}
