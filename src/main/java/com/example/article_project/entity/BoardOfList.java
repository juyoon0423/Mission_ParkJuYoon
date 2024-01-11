package com.example.article_project.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class BoardOfList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String listOfArticle;

    @OneToMany(mappedBy = "boardList")
    private List<Board> inBoard;
}