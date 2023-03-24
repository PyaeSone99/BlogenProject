package com.example.blogenmvc.controller;

import com.example.blogenmvc.entity.Categories;
import com.example.blogenmvc.entity.Posts;
import com.example.blogenmvc.entity.Users;
import com.example.blogenmvc.service.CategoryService;
import com.example.blogenmvc.service.PostService;
import com.example.blogenmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;
    @GetMapping("/")
    public String home(Model model){

        model.addAttribute("alluser",userService.findAllUsers());
        model.addAttribute("allcategory",categoryService.findAllCategories());
        model.addAttribute("post",new Posts());
        model.addAttribute("category",new Categories());
        model.addAttribute("user",new Users());
        model.addAttribute("posts",postService.findAllPosts());
        return "home";
    }

}
