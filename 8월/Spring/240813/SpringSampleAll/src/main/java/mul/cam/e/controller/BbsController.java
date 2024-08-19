package mul.cam.e.controller;

import mul.cam.e.dto.BbsDto;
import mul.cam.e.dto.MemberDto;
import mul.cam.e.service.BbsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RequestMapping("/bbs")
@Controller
public class BbsController {
    private static final Logger log = LoggerFactory.getLogger(BbsController.class);
    private final BbsService service;

    public BbsController(BbsService bbsService) {
        this.service = bbsService;
    }

    @GetMapping("/bbslist.do")
    public String bbslist(Model model) {
        log.info("BbsController bbslist >> " + new Date());

        List<BbsDto> list = service.bbslist();
        System.out.println("--------------->" + list);

        model.addAttribute("bbslist", list);

        return "bbs/bbslist";
    }


    // bbswrite
    @GetMapping("bbswrite.do")
    public String bbswrite(BbsDto bbsDto) {
        log.info("BbsController bbswrite >> " + new Date());

        return "bbs/bbswrite";
    }

    // bbswriteAf -> bbslist
    @PostMapping("bbswriteAf.do")
    public String bbswriteAf(BbsDto bbsDto,  HttpSession session) {
        log.info("BbsController bbswriteAf >> " + new Date());
        service.bbswrite(bbsDto);

        // 세션에서 로그인 정보 가져오기
        MemberDto loginUser = (MemberDto) session.getAttribute("login");
        if (loginUser == null) {
            // 로그인하지 않은 사용자일 경우 로그인 페이지로 리다이렉트
            return "redirect:/login.do";
        }

        // 로그인된 사용자의 ID를 DTO에 설정
        bbsDto.setId(loginUser.getId());

        // 게시글 작성 서비스 호출
        service.bbswrite(bbsDto);

        // 작성 완료 후 게시글 목록 페이지로 리다이렉트
        return "redirect:/bbs/bbslist.do";
    }
}
