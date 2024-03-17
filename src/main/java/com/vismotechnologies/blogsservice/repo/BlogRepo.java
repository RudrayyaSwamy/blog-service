package com.vismotechnologies.blogsservice.repo;

import com.vismotechnologies.blogsservice.entity.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepo  extends JpaRepository<Blogs,Integer> {
}
