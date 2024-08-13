package mul.cam.e;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    private static final Log log = LogFactory.getLog(HelloController.class);

    @GetMapping("hello.do")
    public String hello() {
        log.info("HelloController hello");
        return "hello";
    }
}
