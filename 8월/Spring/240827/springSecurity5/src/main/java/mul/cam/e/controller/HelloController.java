package mul.cam.e.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/home")
    public String home(Locale locale, Model model){
        log.info("HelloController home {}", locale);

        return "home";
    }

    @RequestMapping("/user/page")
    public String userPage(){
        return "/user/page";
    }

    @RequestMapping("/admin/page")
    public String adminPage(){
        return "/admin/page";
    }

    @RequestMapping("/admin/info")
    public String adminInfo(){
        return "/admin/info";
    }

    @GetMapping("/loginPage")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "exception", required = false) String exception,
                            Model model){

        model.addAttribute("error", error);
        model.addAttribute("exception", exception);

        return "/secu/loginPage";
    }

    @RequestMapping("/access_denied_page")
    public String access_denied_page(){
        return "/access_denied_page";
    }

}













