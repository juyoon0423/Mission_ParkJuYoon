package com.example.article_project;

import com.example.article_project.dto.CommentDTO;
import com.example.article_project.entity.Board;
import com.example.article_project.service.BoardOfListService;
import com.example.article_project.service.BoardService;
import com.example.article_project.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final CommentService commentService;
    private final BoardOfListService boardOfListService;


    @GetMapping("/save")
    public String saveForm(Model model) {
        model.addAttribute("boardOfList", boardOfListService.readBoardOfListAll());
        return "save";
    }

    @PostMapping("/save")
    public String save(@RequestParam("boardTitle") String title,
                       @RequestParam("boardPassword") String password,
                       @RequestParam("boardContents") String contents,
                       @RequestParam("boardList-id") Long boardOfListId) {
        boardService.create(title, password, contents, boardOfListId);
        return "redirect:/board/";
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<Board> boardList = boardService.findAll();
        model.addAttribute("boardList", boardList);
        return "list";
    }

    @GetMapping("/{id}")
    public String readOne(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        List<CommentDTO> commentDTOList = commentService.findAll(id);
        model.addAttribute("commentList", commentDTOList);
        model.addAttribute("boardList", boardService.readArtcle(id));
        return "read";
    }

    @GetMapping("/{id}/update-view")
    public String updateView(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        model.addAttribute("boardList", boardService.readArtcle(id));
        return "update";
    }

    @PostMapping("/{id}/update")
    public String update(
            @PathVariable("id")
            Long id,
            @RequestParam("title")
            String title,
            @RequestParam("contents")
            String contents,
            @RequestParam("password")
            String password
    ) {
        boardService.update(
                id, title, contents, password);
        return String.format("redirect:/board/%d", id);
    }


    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        boardService.delete(id);
        return "redirect:/board/";
    }



}
