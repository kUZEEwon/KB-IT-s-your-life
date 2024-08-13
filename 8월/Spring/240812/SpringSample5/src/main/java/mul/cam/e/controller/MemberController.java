package mul.cam.e.controller;

import mul.cam.e.dto.MemberDto;
import mul.cam.e.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
public class MemberController {
    private static final Logger log = LoggerFactory.getLogger(MemberController.class);
    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping("allMember.do")
    public String getAllMember(Model model) {
        System.out.println("MemberController allMember " + new Date());
        List<MemberDto> list = service.allMember();

        model.addAttribute("list", list);

        return "allMember";

    }
}
