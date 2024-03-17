package com.vismotechnologies.blogsservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "user_id")
    private int id;
    private String name;
    private String email;
    private String passward;
    private String role;
    private byte[] profile;

}
