package com.example.blogenmvc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateRegister;
    @OneToMany(mappedBy = "users")
    private List<Posts> postsList = new ArrayList<>();

    public void addPost(Posts posts){
        posts.setUsers(this);
        this.postsList.add(posts);
    }
}
