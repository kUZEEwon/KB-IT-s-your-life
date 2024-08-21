package mul.cam.e.controller;

import mul.cam.e.dto.MemberDto;
import mul.cam.e.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class MemberController {

    private static final Logger log = LoggerFactory.getLogger(MemberController.class);
    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping("login.do")
    public String allMember() {
        log.info("MemberController login " + new Date());
        return "member/login";
    }

    @GetMapping("regi.do")
    public String regi() {
        log.info("MemberController regi " + new Date());
        return "member/regi";
    }

    @ResponseBody   // -> ajax
    @GetMapping("checkId.do")
    public String checkId(String id) {
        log.info("MemberController checkId " + new Date());

        boolean isS = service.getId(id);
        if (isS) {
            return "NO";
        }
        return "YES";
    }

    @PostMapping("regiAf.do")
    public String regiAf(MemberDto dto) {
        log.info("MemberController regiAf " + new Date());

        boolean isS = service.regiAf(dto);
        if (!isS) {
            System.out.println("가입되지 않았습니다");
            return "member/regi";
        }
        return "member/login";
    }

    @PostMapping("loginAf.do")
    public String loginAf(MemberDto dto, HttpServletRequest request) {  // IOC
        log.info("MemberController loginAf " + new Date());

        MemberDto mem = service.login(dto);
        if (mem != null && !mem.getId().equals("")) {         // login 성공!
            request.getSession().setAttribute("login", mem);

            return "redirect:/bbs/bbslist.do";
            // return "forward:/bbslist.do";  // 짐(Object)을 갖고 가고 싶을 경우
        }
        else{   // login 실패~
            //return "member/login";        // view로 이동
            return "redirect:/login.do";    // controller로 이동
        }
    }


}
