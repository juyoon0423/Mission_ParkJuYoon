package com.example.article_project.service;


import com.example.article_project.entity.Board;
import com.example.article_project.repo.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService{
    private final BoardRepository boardRepository;

    public void create(
            String title,
            String password,
            String contents
    ) {
        Board board = new Board();
        board.setBoardTitle(title);
        board.setBoardPassword(password);
        board.setBoardContents(contents);
        boardRepository.save(board);
    }

    public List<Board> findAll() {
        List<Board> boardList = boardRepository.findAll();
        return boardList;
    }

    public Board readArtcle(Long id) {
        Optional<Board> optionalBoard
                = boardRepository.findById(id);
        return optionalBoard.orElse(null);
    }

    public void update(Long id, String title, String contents, String password) {
        Board board = new Board();
        board.setId(id);
        board.setBoardTitle(title);
        board.setBoardContents(contents);
        board.setBoardPassword(password);
        boardRepository.save(board);
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}
