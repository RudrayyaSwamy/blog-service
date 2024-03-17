package com.vismotechnologies.blogsservice.repo;

import com.vismotechnologies.blogsservice.entity.UserDetailsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserDetailsInfo, Integer> {
    Optional<UserDetailsInfo> findByEmail(String email);

    UserDetailsInfo findByName(String name);
}
