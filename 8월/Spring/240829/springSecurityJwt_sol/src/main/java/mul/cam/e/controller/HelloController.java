package mul.cam.e.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/home")
    public String home(Locale locale, Model model){
        log.info("HelloController home {}", locale);

        return "home";
    }

    @GetMapping("/test")
    public String test(Locale locale, Model model){
        log.info("HelloController test {}", locale);

        return "test success";
    }
}
