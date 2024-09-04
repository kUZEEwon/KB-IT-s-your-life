package mul.cam.e.controller;

import mul.cam.e.dto.BbsDto;
import mul.cam.e.dto.BbsParam;
import mul.cam.e.service.BbsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bbs")
public class BbsController {

    private static final Logger log = LoggerFactory.getLogger(BbsController.class);
    private final BbsService service;

    public BbsController(BbsService service) {
        this.service = service;
    }

    @PostMapping("/bbsList")
    public Map<String, Object> bbsList(@RequestBody BbsParam param) {
        log.info("BbsController bbsList");
        log.info("param:{}", param);

        // 글목록
        List<BbsDto> list = service.bbsList(param);

        // 글의 총수
        int count = service.allBbs(param);

        Map<String, Object> map = new HashMap<>();
        map.put("bbslist", list);
        map.put("cnt", count);

        return map;
    }

    @PostMapping("bbswrite")
    public String bbswrite(@RequestBody BbsDto bbs) {
        System.out.println("BbsController bbswrite " + new Date());

        int count = service.bbsWrite(bbs);
        if(count == 0) {
            return "NO";
        }
        return "YES";
    }

    @PostMapping("bbsdetail")
    public BbsDto bbsdetail(@RequestBody BbsDto bbs) {
        System.out.println("BbsController bbsdetail " + new Date());

        BbsDto dto = service.bbsDetail(bbs);
        return dto;
    }

    @PostMapping("bbsanswer")
    public String bbsanswer(@RequestBody BbsDto bbs) {
        System.out.println("BbsController bbsanswer " + new Date());
        System.out.println(bbs.toString());

        int count = service.bbsAnswer(bbs);
        if(count > 0) {
            return "YES";
        }
        return "NO";
    }

    @PostMapping(value = "bbsupdate")
    public String bbsupdate(@RequestBody BbsDto dto) {
        System.out.println("BbsController bbsupdate " + new Date());

        int count = service.bbsUpdate(dto);
        if(count > 0) {
            return "YES";
        }
        return "NO";
    }

}
