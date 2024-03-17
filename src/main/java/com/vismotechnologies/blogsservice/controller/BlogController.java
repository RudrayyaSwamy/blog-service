package com.vismotechnologies.blogsservice.controller;


import com.vismotechnologies.blogsservice.entity.Blogs;
import com.vismotechnologies.blogsservice.model.BlogsModel;
import com.vismotechnologies.blogsservice.service.BlogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@Tag(name = "Blogs Controller")
public class BlogController {

    private BlogService blogService;

    @GetMapping("/blog/findBlog/{blogId}")
    public ResponseEntity<Optional<Blogs>> findBlog(@PathVariable Integer blogId) {
        return blogService.findBlog(blogId);
    }

    @GetMapping("/blog/findAllBlog")
    public ResponseEntity<List<BlogsModel>> findAllBlog() {
        return blogService.findAllBlog();
    }

    @PostMapping("/admin/blog/saveBlog")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Blogs> saveBlog(@RequestBody Blogs blogs) {
        return  ResponseEntity.ok(blogService.saveBlog(blogs));
    }

    @PutMapping("/admin/blog/updateBlog")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Blogs> updateBlog(@RequestBody  Blogs blogs) {
        return ResponseEntity.ok(blogService.updateBlog(blogs));
    }

    @GetMapping("/admin/blog/deleteBLog/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> deleteBLog(@PathVariable int id) {
        blogService.deleteBLog(id);
        return new ResponseEntity<>("Resource deleted successfully", HttpStatus.OK);
    }
}
