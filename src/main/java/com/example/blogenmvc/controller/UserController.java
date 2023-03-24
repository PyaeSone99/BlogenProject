package com.example.blogenmvc.controller;

import com.example.blogenmvc.entity.Users;
import com.example.blogenmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/save-user")
    public String saveUser(Users users, BindingResult result){
        if (result.hasErrors()){
            return "home";
        }
        userService.saveUser(users);
        return "redirect:/";
    }

    @GetMapping("/list-user")
    public String listUsers(Model model){
        model.addAttribute("users",userService.findAllUsers());
        return "users";
    }

}
