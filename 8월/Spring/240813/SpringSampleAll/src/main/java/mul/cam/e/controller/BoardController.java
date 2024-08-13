package mul.cam.e.controller;

import mul.cam.e.dto.BoardDto;
import mul.cam.e.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {
    private static final Logger log = LoggerFactory.getLogger(MemberController.class);
    private final BoardService boardService;
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("bbslist.do")
    public ModelAndView bbslist() {
        List<BoardDto> all = boardService.all();
        System.out.println("---------->> " + all);
        ModelAndView mav = new ModelAndView();
        mav.addObject("boards", all);
        mav.setViewName("board/bbslist");
        return mav;
    }
}
