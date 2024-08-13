package com.multi.win00.controller;

import com.multi.win00.domain.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class BoardController {
    @GetMapping("/insert")
    public String insert(int no, String title, String content, String writer) {
        log.info("================> BoardController insert/");

        log.info("no: " + no);
        log.info("title: " + title);
        log.info("content: " + content);
        log.info("writer: " + writer);
        return "insert";
    }

    @GetMapping("/delete")
    public String delete(int no) {
        log.info("================> BoardController delete/");
        log.info("no: " + no);
        return "delete";
    }

    @PostMapping("one")
    public ModelAndView one(int no) {
        log.info("================> BoardController one/");

        BoardVO boardVO = new BoardVO();
        boardVO.setNo(no);
        boardVO.setTitle("fun");
        boardVO.setContent("fun");
        boardVO.setWriter("apple");
        ModelAndView modelAndView = new ModelAndView("one");  // "one" 뷰 이름 설정
        modelAndView.addObject("board", boardVO);
        return modelAndView;

    }

    @RequestMapping(value = "/update", method = RequestMethod.GET) //선택가능
    public String update(@RequestParam("no") int no, @RequestParam("title") String title) {
        log.info("===============> BoardController update/");
        log.info("no: " + no);
        log.info("title: " + title);
        return "redirect:/";
    }
}

