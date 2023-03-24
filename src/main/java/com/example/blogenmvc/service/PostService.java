package com.example.blogenmvc.service;

import com.example.blogenmvc.dao.CategoryDao;
import com.example.blogenmvc.dao.PostDao;
import com.example.blogenmvc.dao.UserDao;
import com.example.blogenmvc.entity.Categories;
import com.example.blogenmvc.entity.Posts;
import com.example.blogenmvc.entity.Users;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;

    @Transactional
    public void savePost(Posts posts){
        Categories categories = categoryDao.findById(posts.getCategories().getId()).orElseThrow(EntityNotFoundException::new);
        Users users = userDao.findById(posts.getUsers().getId()).orElseThrow(EntityNotFoundException::new);
        categories.addPost(posts);
        users.addPost(posts);
        postDao.save(posts);
    }

    public List<Posts> findAllPosts(){
        return postDao.findAll();
    }
}
