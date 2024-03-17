package com.vismotechnologies.blogsservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
@Data
@Table(name = "user_details", schema = "vtbloges", catalog = "")
public class UserDetailsInfo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Basic
    @Column(name = "email", nullable = true, length = 45)
    private String email;
    @Basic
    @Column(name = "passward", nullable = true, length = 1000)
    private String passward;
    @Basic
    @Column(name = "role", nullable = true, length = 45)
    private String role;
    @Basic
    @Column(name = "profile", nullable = true)
    private byte[] profile;
   /* @OneToMany(mappedBy = "userDetailsByUserId")
    private Collection<CommentsDetails> commentsDetailsById;*/

}
