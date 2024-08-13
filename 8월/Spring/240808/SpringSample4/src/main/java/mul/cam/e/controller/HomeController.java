package mul.cam.e.controller;

import mul.cam.e.dto.HumanDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    private static final Log log = LogFactory.getLog(HomeController.class);

    @GetMapping("home.do")
    public String home() {
        System.out.println("HomeController home >>");
        return "home";
    }

    @ResponseBody
    @GetMapping(value = "idcheck.do", produces = "application/String; charset=utf-8")
    public String idcheck(String id) {
        System.out.println("HomeController idcheck >>");
        System.out.println("id >> " + id);

        // db 접금
        String ans = "사용 가능";


        return ans;
    }

    @ResponseBody
    @PostMapping(value = "account.do",  produces = "application/String; charset=utf-8")
    public Map<String, Object> account(HumanDto humanDto) {
        System.out.println("HomeController account >>");
        System.out.println("humanDto >> " + humanDto);

        // db 접근

        // back => front
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "반갑습니다");
        map.put("name", "송중기");

        return map;
    }

}
