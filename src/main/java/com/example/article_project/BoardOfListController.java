package com.example.article_project;

import com.example.article_project.entity.BoardOfList;
import com.example.article_project.service.BoardOfListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boardOfList")
public class BoardOfListController {
    private final BoardOfListService boardOfListService;

    @GetMapping()
    public String readAll(Model model) {
        model.addAttribute("ofList", boardOfListService.readBoardOfListAll());
        return "boardOfList/home";
    }

    @GetMapping("/{id}")
    public String readOne(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        model.addAttribute("boardList", boardOfListService.readBoardOfList(id));
        return "boardOfList/read";
    }
}
