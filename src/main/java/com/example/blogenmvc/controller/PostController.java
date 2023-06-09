package com.example.blogenmvc.controller;

import com.example.blogenmvc.entity.Posts;
import com.example.blogenmvc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/save-post")
    public String savePost(Posts posts, BindingResult result){
        if (result.hasErrors()){
            return "home";
        }
        postService.savePost(posts);
        return "redirect:/";
    }
    @GetMapping("/list-post")
    public String listPost(Model model){
        model.addAttribute("posts",postService.findAllPosts());
        return "posts";
    }
}
