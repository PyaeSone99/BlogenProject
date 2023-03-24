package com.example.blogenmvc.controller;

import com.example.blogenmvc.entity.Categories;
import com.example.blogenmvc.entity.Users;
import com.example.blogenmvc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/save-category")
    public String saveCategory(Categories categories, BindingResult result){
        if (result.hasErrors()){
            return "home";
        }
        categoryService.saveCategory(categories);
        return "redirect:/";
    }

    @GetMapping("/list-category")
    public String listCategories(Model model){
        model.addAttribute("categories",categoryService.findAllCategories());
        return "categories";
    }


}
