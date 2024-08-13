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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class MemberController {
    private static final Logger log = LoggerFactory.getLogger(MemberController.class);
    private final MemberService service;
    private final MemberService memberService;

    public MemberController(MemberService service, MemberService memberService) {
        this.service = service;
        this.memberService = memberService;
    }

    @GetMapping("login.do")
    public String getAllMember(Model model) {
        System.out.println("MemberController login " + new Date());

        return "member/login";
    }

    @ResponseBody // -> ajax
    @GetMapping("checkId.do")
    public String checkId(String id) {
        log.info("MemberController checkId " + new Date());

        boolean isSuccess = memberService.getId(id);
        if (isSuccess) {
            // 사용 불가함
            return "NO";
        }
        return "YES";
    }

    @PostMapping("loginAf.do")
    public String loginAf(MemberDto memberDto, HttpSession session) {
        System.out.println("MemberController loginAf " + new Date());
        int result = memberService.login(memberDto);
        System.out.println("--------->> " + result);
        if (result == 1){
            session.setAttribute("login_id", memberDto.getId());
            return "member/login_ok";
        }else{
            return "member/login_no";
        }

    }

    @GetMapping("regi.do")
    public String getRegi() {
        log.info("MemberController regi " + new Date());
        return "member/regi";
    }

    @PostMapping("regiAf.do")
    public String regiAf(MemberDto memberDto) {
        log.info("MemberController regiAf " + new Date());
        System.out.println(memberDto);
        boolean result = memberService.regi(memberDto);
        System.out.println("---------->> " + result);
        if(!result){
            System.out.println("회원 가입 실패함");
            return "member/regi";
        }else{
            return "member/login";
        }
    }
}
