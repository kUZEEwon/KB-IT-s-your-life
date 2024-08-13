package mul.cam.e.controller;
import mul.cam.e.dto.HumanDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
    private static final Log log = LogFactory.getLog(HomeController.class);
    // @RequestMapping(value = "home", method = RequestMethod.GET) // <a href="home"   <form action="home"
    // @GetMapping("home") <= 요즘 방식

    // get, post를 신경쓰고 싶지 않다면?
    @RequestMapping(value = "home.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String home() {
//        System.out.println("HomeController home " + new Date());
        log.info("HomeController home");
        return "home";      // WEB-INF/views/home.jsp 이 이름에 해당하는 jsp로 이동
    }

    // 1(컨트롤러 -> 뷰)
    @GetMapping("hello.do")
    public String hello(Model model) {
        log.info("HomeController Hello >>>>>>>>>");

        String name = "구지원"; // request.setAttribute => request.getAttribute

        // ModelAndView, Model
        model.addAttribute("name", name); // setAttribute 와 동일함
        return "home";
    }

    @PostMapping("info.do")
    //public String info(String name, int age) { // age의 자료형을  int로 강제형변환 (IOC)
    public String info(HumanDto human) {
        log.info("HomeController info >>>>>>>>>");
     //   log.info("name: " + name + "\nage: " + age);
        log.info(human.toString());
        return "home";
    }

    @GetMapping("list.do")
    public String list(Model model) {
        log.info("HomeController list >>>>>>>>>");
        // 리스트 보내기
        List<HumanDto> list = new ArrayList<>();
        list.add(new HumanDto("송중기",37));
        list.add(new HumanDto("AMY",25));
        list.add(new HumanDto("JAMES",67));

        model.addAttribute("list", list);
        return "home";
    }
}
