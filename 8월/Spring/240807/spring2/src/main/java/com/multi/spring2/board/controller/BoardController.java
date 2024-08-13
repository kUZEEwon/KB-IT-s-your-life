package com.multi.spring2.board.controller;

import com.multi.spring2.member.domain.MemberVO;
import com.multi.spring2.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
 public class BoardController {
 public BoardController() {
  System.out.println("BoardController created");
 }

 @RequestMapping
 public String boardHome() {
  return "board/board";
 }
}