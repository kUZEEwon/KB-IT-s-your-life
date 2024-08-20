package mul.cam.e.controller;

import mul.cam.e.dto.BbsDto;
import mul.cam.e.dto.BbsPram;
import mul.cam.e.service.BbsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/bbs")
public class BbsController {

    private static final Logger log = LoggerFactory.getLogger(BbsController.class);
    private final BbsService service;

    public BbsController(BbsService service) {
        this.service = service;
    }

    @GetMapping("/bbslist.do")
    public String bbslist(Model model, BbsPram param) {
        log.info("BbsController bbslist " + new Date());
        if(param == null || param.getKeyword() == null || param.getCategory() == null) {
            param = new BbsPram("","",0);

        }

        List<BbsDto> list = service.bbslist(param);
        System.out.println("list : " +list);

        // 글의 총 수
        int count = service.getTotalBbs(param);

        // page를 계산
        int pageBbs = count / 10;
        if (count % 10 > 0) {
            pageBbs++;
        }

        model.addAttribute("bbslist", list);
        model.addAttribute("param", param);
        model.addAttribute("pageBbs", pageBbs);

        return "bbs/bbslist";
    }

    // bbswrite
    @GetMapping("/bbswrite.do")
    public String bbswrite() {
        log.info("BbsController bbswrite " + new Date());
        return "bbs/bbswrite";
    }

    // bbswriteAf -> bbslist
    @PostMapping("/bbswriteAf.do")
    public String bbswriteAf(BbsDto dto) {
        log.info("BbsController bbswriteAf " + new Date());

        boolean result = service.bbswrite(dto);
        if(!result){
            System.out.println("글 쓰기 실패!");
            return "redirect:/bbs/bbswrite.do";
        }
        return "redirect:/bbs/bbslist.do";
    }
}
