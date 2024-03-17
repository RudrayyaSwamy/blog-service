package com.vismotechnologies.blogsservice.model;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
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
    @OneToMany(mappedBy = "userDetailsByUserId")
    private Collection<CommentsDetails> commentsDetailsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public byte[] getProfile() {
        return profile;
    }

    public void setProfile(byte[] profile) {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetailsInfo that = (UserDetailsInfo) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(passward, that.passward) && Objects.equals(role, that.role) && Arrays.equals(profile, that.profile);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, email, passward, role);
        result = 31 * result + Arrays.hashCode(profile);
        return result;
    }

    public Collection<CommentsDetails> getCommentsDetailsById() {
        return commentsDetailsById;
    }

    public void setCommentsDetailsById(Collection<CommentsDetails> commentsDetailsById) {
        this.commentsDetailsById = commentsDetailsById;
    }
}
