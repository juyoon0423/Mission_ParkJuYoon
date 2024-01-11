package com.example.article_project.repo;

import com.example.article_project.entity.BoardOfList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardOfListRepository extends JpaRepository<BoardOfList, Long> {
}
