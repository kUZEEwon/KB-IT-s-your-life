package mul.cam.e.controller;

import mul.cam.e.dto.MemberDto;
import mul.cam.e.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping("allMember.do")
    public String allMember(Model model) {
        System.out.println("MemberController allMember >> ");
        List<MemberDto> members = service.allMember();
        for (MemberDto member : members) {
            System.out.println(member);
        }
        return "allMember";
    }
}
