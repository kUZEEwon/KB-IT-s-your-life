package mul.cam.e.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import mul.cam.e.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @ResponseBody
    @GetMapping("/world")
    public String world(String str) throws JsonProcessingException {
        //System.out.println("mem : " + mem);
        System.out.println("json: " + str);

        // String => List
        ObjectMapper mapper = new ObjectMapper();
        List<Member> list = mapper.readValue(str, new TypeReference<List<Member>>(){});

        for(Member member : list) {
            System.out.println(member.toString());
        }

        return "success";
    }
}
