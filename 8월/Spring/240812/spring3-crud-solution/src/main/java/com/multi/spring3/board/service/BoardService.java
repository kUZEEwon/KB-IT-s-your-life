package com.multi.spring3.board.service;

import com.multi.spring3.board.dao.BoardDAO;
import com.multi.spring3.board.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardDAO boardDAO;

    @Autowired
    public BoardService(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    public String insert(BoardVO boardVO){
        String result = "게시판 글삽입 실패";
        if(boardDAO.insert(boardVO) == 1){
            result = "게시판 글삽입 성공";
        };
        return result;
    }

    public String update(BoardVO boardVO){
        String result = "게시판 글수정 실패";
        if(boardDAO.update(boardVO) != 0){
            result = "게시판 글수정 성공";
        };
        return result;
    }

    public String delete(int no){
        String result = "게시판 글삭제 실패";
        if(boardDAO.delete(no) != 0){
            result = "게시판 글삭제 성공";
        };
        return result;
    }
}