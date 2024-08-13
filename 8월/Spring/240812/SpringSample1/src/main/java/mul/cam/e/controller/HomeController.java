package mul.cam.e.controller;

import mul.cam.e.dto.HumanDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private static final Log log = LogFactory.getLog(HomeController.class);

    //@RequestMapping(value = "home", method = { RequestMethod.GET, RequestMethod.POST })     // <a href="home"  <form action="home"
    @GetMapping("home.do")
    public String home() {
        // System.out.println("HomeController home " + new Date());
        log.info("HomeController home");

        return "home";  // WEB-INF/views/home.jsp
    }

    // 1
    @GetMapping("hello.do")
    public String hello(Model model) {
        log.info("HelloController hello");

        String name = "성춘향";    // request.setAttribute -> request.getAttribute

        // ModelAndView, Model
        model.addAttribute("name", name);   // 짐싸!
        return "home";
    }

    // 2
    @PostMapping("info.do")
    // public String info(String name, int age) {  // IOC
    public String info(HumanDto human) {  // IOC
        log.info("HelloController info");

        //log.info("name: " + name);
        //log.info("age: " + age);

        log.info(human.toString());

        return "home";
    }

    @GetMapping("list.do")
    public String list(Model model) {
        log.info("HelloController list");

        List<HumanDto> list = new ArrayList<>();
        list.add(new HumanDto("홍길동", 24));
        list.add(new HumanDto("성춘향", 16));
        list.add(new HumanDto("일지매", 22));

        model.addAttribute("list", list);

        return "home";
    }

}
