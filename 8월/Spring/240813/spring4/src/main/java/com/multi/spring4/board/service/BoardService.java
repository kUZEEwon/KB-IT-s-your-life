package com.multi.spring4.board.service;

import com.multi.spring4.board.dao.BoardDAO;
import com.multi.spring4.board.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
 public class BoardService {

    private BoardDAO boardDAO;

    public BoardService(){
        System.out.println("BoardService created");
    }

    @Autowired
    public BoardService(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    public List<BoardVO> all(){
        return boardDAO.all();
    }

}