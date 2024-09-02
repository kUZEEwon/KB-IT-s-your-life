package com.multi.spring2.people.controller;

import com.multi.spring2.people.domain.PeopleVO;
import com.multi.spring2.people.service.PeopleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/people")
@Api(value = "PeopleController", tags = "영화인정보")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public String index() {
        return "people/people";
    }

    @RequestMapping("insert")
    @ResponseBody
    public String insert(@RequestBody PeopleVO peopleVO) {
        System.out.println(peopleVO);
        return peopleService.insert(peopleVO);
    }

    @RequestMapping("all")
    @ResponseBody
    public List<PeopleVO> all() {
        System.out.println("PeopleController.all");
        return peopleService.all();
    }
}
