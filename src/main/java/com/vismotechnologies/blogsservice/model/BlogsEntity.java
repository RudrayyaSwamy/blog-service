package com.vismotechnologies.blogsservice.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "blogs", schema = "vtbloges", catalog = "")
public class BlogsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "blog_id", nullable = false)
    private int blogId;
    @Basic
    @Column(name = "title", nullable = true, length = 45)
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
    @OneToOne
    @JoinColumn(name = "blog_id", referencedColumnName = "id", nullable = false)
    private UserDetailsEntity userDetailsByBlogId;
    @OneToMany(mappedBy = "blogsByBlogDetailId")
    private Collection<CommentsDetailsEntity> commentsDetailsByBlogId;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlogsEntity that = (BlogsEntity) o;
        return blogId == that.blogId && Objects.equals(title, that.title) && Objects.equals(shortDescription, that.shortDescription) && Objects.equals(body, that.body) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blogId, title, shortDescription, body, userId);
    }

    public UserDetailsEntity getUserDetailsByBlogId() {
        return userDetailsByBlogId;
    }

    public void setUserDetailsByBlogId(UserDetailsEntity userDetailsByBlogId) {
        this.userDetailsByBlogId = userDetailsByBlogId;
    }

    public Collection<CommentsDetailsEntity> getCommentsDetailsByBlogId() {
        return commentsDetailsByBlogId;
    }

    public void setCommentsDetailsByBlogId(Collection<CommentsDetailsEntity> commentsDetailsByBlogId) {
        this.commentsDetailsByBlogId = commentsDetailsByBlogId;
    }
}
