package com.vismotechnologies.blogsservice.repo;

import com.vismotechnologies.blogsservice.model.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepo  extends JpaRepository<Blogs,Integer> {
}
