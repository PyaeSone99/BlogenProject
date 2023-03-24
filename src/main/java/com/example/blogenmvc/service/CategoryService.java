package com.example.blogenmvc.service;

import com.example.blogenmvc.dao.CategoryDao;
import com.example.blogenmvc.dao.PostDao;
import com.example.blogenmvc.dao.UserDao;
import com.example.blogenmvc.entity.Categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;


    public void saveCategory(Categories categories){
        categoryDao.save(categories);
    }

    public List<Categories> findAllCategories(){
        return categoryDao.findAll();
    }
}














