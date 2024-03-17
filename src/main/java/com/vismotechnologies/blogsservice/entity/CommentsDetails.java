package com.vismotechnologies.blogsservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "comments_details", schema = "vtbloges", catalog = "")
public class CommentsDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int commentId;
    private String comment;
    @Column(name = "blog_detail_id")
    private Integer blogDetailId;
    private Timestamp commentOn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserDetailsInfo userDetailsInfo;
}
