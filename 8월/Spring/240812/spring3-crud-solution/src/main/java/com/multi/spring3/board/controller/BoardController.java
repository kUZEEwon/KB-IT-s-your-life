package com.multi.spring3.board.controller;

import com.multi.spring3.board.domain.BoardVO;
import com.multi.spring3.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

 private final BoardService boardService;

 @Autowired
 public BoardController(BoardService boardService) {
  System.out.println("BoardController created");
  this.boardService = boardService;
 }

 @GetMapping
 public String index() {
  return "board/board";
 }

 @PostMapping("/insert")
 public ModelAndView insert(BoardVO boardVO) {
  System.out.println(boardVO);
  String result = boardService.insert(boardVO);
  System.out.println("--------->> " + result);
  ModelAndView modelAndView = new ModelAndView();
  modelAndView.addObject("result", result);
  modelAndView.setViewName("board/insert_result");
  return modelAndView;
 }

 @PostMapping("/update")
 public ModelAndView update(BoardVO boardVO) {
  String result = boardService.update(boardVO);
  System.out.println("--------->> " + result);
  ModelAndView modelAndView = new ModelAndView();
  modelAndView.addObject("result", result);
  modelAndView.setViewName("board/update_result");
  return modelAndView;
 }

 @GetMapping("/delete")
 public ModelAndView delete(@RequestParam("no") int no) {
  String result = boardService.delete(no);
  System.out.println("--------->> " + result);
  ModelAndView modelAndView = new ModelAndView();
  modelAndView.addObject("result", result);
  modelAndView.setViewName("board/delete_result");
  return modelAndView;
 }

}
