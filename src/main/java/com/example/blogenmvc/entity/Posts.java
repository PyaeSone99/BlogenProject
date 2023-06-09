package com.example.blogenmvc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    @Column(columnDefinition = "text")
    private String body;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePosted;
    @ManyToOne
    private Categories categories;

    @ManyToOne
    private Users users;
}
