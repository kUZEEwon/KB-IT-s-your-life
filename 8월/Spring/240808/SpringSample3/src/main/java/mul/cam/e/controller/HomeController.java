package mul.cam.e.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    private static final Log log = LogFactory.getLog(HomeController.class);
    // @RequestMapping(value = "home", method = RequestMethod.GET) // <a href="home"   <form action="home"

    // get, post를 신경쓰고 싶지 않다면?
    //@RequestMapping(value = "home.do", method = {RequestMethod.GET, RequestMethod.POST})
    @GetMapping("home.do")
    public String home() {
//        System.out.println("HomeController home " + new Date());
        log.info("HomeController home");
        return "home";      // WEB-INF/views/home.jsp 이 이름에 해당하는 jsp로 이동
    }

    @GetMapping("hello.do")
    public String hello() {
//        System.out.println("HomeController home " + new Date());
        log.info("HomeController hello");
        return "hello";      // WEB-INF/views/home.jsp 이 이름에 해당하는 jsp로 이동
    }
}
