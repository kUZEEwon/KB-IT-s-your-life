package mul.cam.e.controller;

import mul.cam.e.dto.BbsComment;
import mul.cam.e.dto.BbsDto;
import mul.cam.e.dto.BbsParam;
import mul.cam.e.service.BbsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/bbs")
public class BbsController {

    //private static final Logger log = LoggerFactory.getLogger(BbsController.class);
    private final BbsService service;

    public BbsController(BbsService service) {
        this.service = service;
    }

    @GetMapping("/bbslist.do")
    public String bbslist(Model model, BbsParam param) {
        //log.info("BbsController bbslist " + new Date());

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
        //log.info("BbsController bbswrite " + new Date());

        return "bbs/bbswrite";
    }

    // bbswriteAf -> bbslist
    @PostMapping("/bbswriteAf.do")
    public String bbswriteAf(BbsDto dto) {
        //log.info("BbsController bbswriteAf " + new Date());

        boolean result = service.bbswrite(dto);
        if (!result) {
            System.out.println("추가되지 않았습니다");
            return "redirect:/bbs/bbswrite.do";
        }

        return "redirect:/bbs/bbslist.do";
    }

    @GetMapping("/bbsdetail.do")
    public String bbsdetail(Model model, int seq) {
        BbsDto dto = service.bbsdetail(seq);
        model.addAttribute("bbs", dto);
        return "bbs/bbsdetail";
    }

    @GetMapping("/bbsupdate.do")
    public String bbsupdate(Model model, int seq) {
        BbsDto dto = service.bbsdetail(seq);
        model.addAttribute("bbs", dto);
        return "bbs/bbsupdate";
    }
    @GetMapping("/bbsupdateAf.do")
    public String bbsupdateAf(Model model, BbsDto dto) {
        boolean result = service.bbsupdate(dto);
        if (!result) {
            model.addAttribute("seq", dto.getSeq());
            return "forward:/bbs/bbsupdate.do";
        }

        return "redirect:/bbs/bbslist.do";
    }

    @GetMapping("/bbsanswer.do")
    public String bbsanswer(Model model, int seq) {
        BbsDto dto = service.bbsdetail(seq);
        model.addAttribute("bbs", dto);
        return "bbs/bbsanswer";
    }

    @PostMapping("/bbsanswerAf.do")
    public String bbsanswerAf(Model model, BbsDto dto) {
        boolean result = service.bbsanswer(dto);
        if (!result) {
            model.addAttribute("seq", dto.getSeq());
            return "forward:/bbs/bbsanswer.do";
        }
        return "redirect:/bbs/bbslist.do";
    }

    @PostMapping("commentWrite.do")
    public String commentWrite(BbsComment comment){
        boolean isS = service.commentWrite(comment);
        if(isS){
            System.out.println("댓글 작성 성공!");
        }else{
            System.out.println("댓글 작성 실패!");
        }

        return "redirect:/bbs/bbsdetail.do?seq=" + comment.getSeq();
    }

    @ResponseBody
    @GetMapping("commentList.do")
    public List<BbsComment> commentList(int seq){
        return service.commentList(seq);
    }



}
