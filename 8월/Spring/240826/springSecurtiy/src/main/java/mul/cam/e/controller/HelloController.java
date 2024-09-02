package mul.cam.e.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
public class HelloController {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/home")
    public String home(Locale locale, Model model) {
        log.info("HelloController home{}", locale);

        return "home";
    }

    @RequestMapping("/user/page")
    public String userPage() {
        log.info("HelloController userPage{}");
        return "/user/page";
    }

    @RequestMapping("/admin/page")
    public String adminPage() {
        log.info("HelloController adminPage{}");
        return "/admin/page";
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        log.info("HelloController loginPage{}");
        return "/secu/loginPage";
    }
}
