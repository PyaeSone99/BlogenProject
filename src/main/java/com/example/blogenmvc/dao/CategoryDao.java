package com.example.blogenmvc.dao;

import com.example.blogenmvc.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Categories,Integer> {
}
