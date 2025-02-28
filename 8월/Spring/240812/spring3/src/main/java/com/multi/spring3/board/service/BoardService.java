package com.multi.spring3.board.service;

import com.multi.spring3.board.dao.BoardDAO;
import com.multi.spring3.member.domain.BoardVO;
import com.multi.spring3.member.domain.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardDAO boardDAO;


    @Autowired
    public BoardService(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
        System.out.println("BoardService created");
    }

    public String insert(BoardVO boardVO){
        String result = "글 작성 실패";
        if(boardDAO.insert(boardVO) == 1){
            result = "글 작성 성공";
        };
        return result;
    }

    public String update(BoardVO boardVO){
        String result = "글 수정 실패";
        if(boardDAO.update(boardVO) != 0){
            result = "글 수정 성공";
        };
        return result;
    }

    public String delete(int no){
        String result = "글 삭제 실패";
        if(boardDAO.delete(no) != 0){
            result = "글 삭제 성공";
        };
        return result;
    }

    public BoardVO one(int no) {
        return boardDAO.one(no);
    }

    public List<BoardVO> all() {
        return boardDAO.all();
    }
}
