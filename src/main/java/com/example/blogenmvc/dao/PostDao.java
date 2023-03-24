package com.example.blogenmvc.dao;

import com.example.blogenmvc.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDao extends JpaRepository<Posts,Integer> {
}
