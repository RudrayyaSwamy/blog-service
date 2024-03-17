package com.vismotechnologies.blogsservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Data
@Table(name = "blogs", schema = "vtbloges", catalog = "")
public class Blogs {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "blog_id")
    private int blogId;
    private String title;
    private String shortDescription;
    private String body;
    private Timestamp createdOn;
    private Timestamp updatedOn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserDetailsInfo userDetailsInfo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "blog_detail_id")
    private Set<CommentsDetails> commentsDetailsByBlogId;


}
