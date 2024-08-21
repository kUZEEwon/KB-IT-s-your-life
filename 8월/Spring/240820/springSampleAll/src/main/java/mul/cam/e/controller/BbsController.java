package mul.cam.e.controller;

import mul.cam.e.dto.BbsDto;
import mul.cam.e.dto.BbsParam;
import mul.cam.e.service.BbsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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
    public String bbslist(Model model, BbsParam param) {
        log.info("BbsController bbslist " + new Date());

        if (param == null || param.getKeyword() == null || param.getCategory() == null) {
            param = new BbsParam("", "", 0);
        }

        List<BbsDto> list = service.bbslist(param);

        // 글의 총수
        int count = service.getTotalBbs(param);
        // 페이지를 계산
        int pageBbs = count / 10;
        if (count % 10 > 0) {
            pageBbs++;
        }

        model.addAttribute("bbslist", list);
        model.addAttribute("pageBbs", pageBbs);
        model.addAttribute("param", param);

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
        if (!result) {
            System.out.println("추가되지 않았습니다");
            return "redirect:/bbs/bbswrite.do";
        }

        return "redirect:/bbs/bbslist.do";
    }

    @GetMapping("/bbsdetail.do")
    public String bbsdetail(Model model,int seq) {
        log.info("BbsController bbsdetail " + new Date());
        BbsDto list = service.bbsdetail(seq);
        model.addAttribute("bbsdetail", list);

        return "bbs/bbsdetail";
    }

    @GetMapping("/bbsdelete.do")
    public String bbsdelete(Model model, int seq) {
        log.info("BbsController bbsdelete " + new Date());
        int result = service.bbsdelete(seq);

        if(result > 0) {

          //model.addAttribute("message",  "삭제가 성공적으로 완료되었습니다.");
          return "redirect:/bbs/bbslist.do";
        }else{
           // model.addAttribute("message", "삭제에 실패했습니다.");
            return "redirect:/bbs/bbsdetail.do?seq=" + seq;
        }
    }

    @GetMapping("/bbsupdate.do")
    public String bbsupdate(Model model, @RequestParam("seq") int seq) {
        // 게시글 세부 정보를 가져옵니다.
        BbsDto bbsDetail = service.bbsdetail(seq);
        model.addAttribute("bbsdetail", bbsDetail);

        // 수정 폼 뷰를 반환합니다.
        return "bbs/bbsupdate";
    }

    @PostMapping("/bbsupdateAf.do")
    public String bbsupdateAf(Model model, BbsDto bbsDto) {
        log.info("BbsController bbsupdate " + new Date());
        int result = service.bbsupdate(bbsDto);
        if(result > 0) {
            String msg = "게시물 수정 성공!";
            System.out.println(msg);

            return "redirect:/bbs/bbslist.do";
        }else{
            //게시물이 성공적으로 업로드가 안됨
            System.out.println("게시물이 성공적으로 업로드가 안됨");
            return "redirect:/bbs/bbsupdate.do?seq=" + bbsDto.getSeq();
        }
    }
}
