package com.vismotechnologies.blogsservice.controller;


import com.vismotechnologies.blogsservice.model.Blogs;
import com.vismotechnologies.blogsservice.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1")
public class BlogController {

    private BlogService blogService;

    @GetMapping("/blog/findBlog/{blogId}")
    public ResponseEntity<Optional<Blogs>> findBlog(@PathVariable Integer blogId) {
        return blogService.findBlog(blogId);
    }

    @GetMapping("/blog/findAllBlog")
    public ResponseEntity<List<Blogs>> findAllBlog() {
        return blogService.findAllBlog();
    }

    @PostMapping("/admin/blog/saveBlog")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Blogs saveBlog(@RequestBody Blogs blogs) {
        return blogService.saveBlog(blogs);
    }

    @PutMapping("/admin/blog/updateBlog")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Blogs updateBlog(@RequestBody  Blogs blogs) {
        return blogService.updateBlog(blogs);
    }

    @GetMapping("/admin/blog/deleteBLog/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteBLog(@PathVariable int id) {
        blogService.deleteBLog(id);
    }
}
