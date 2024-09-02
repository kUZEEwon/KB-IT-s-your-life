package mul.cam.e.controller;

import mul.cam.e.dto.MemberDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController // == controller + ResponseBody
public class SwaggerController {

    @GetMapping(value = "/hello",produces = "text/html;charset=utf-8")
    public String getMessage() {
        System.out.println("hello");
        return "안녕하세요";
    }

    @GetMapping("/login")
    public String login(String id, String password) {
        System.out.println("id=" + id + " ,password=" + password);
        return "login ok";
    }

    // Parameter : MemberDto

    // return : List<MemberDto> list = 2 ~ 3개 리턴
    @GetMapping("/member")
    public List<MemberDto> member(MemberDto member) {
        List<MemberDto> list = new ArrayList<MemberDto>();
        list.add(member);
        list.add(new MemberDto("id","pw","name","email",1));
        list.add(new MemberDto("id2","pw2","name2","email2",1));
        return list;
    }

}
