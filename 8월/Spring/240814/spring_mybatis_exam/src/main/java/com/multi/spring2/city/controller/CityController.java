package com.multi.spring2.city.controller;

import com.multi.spring2.city.domain.CityVO;
import com.multi.spring2.city.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {
    private static final Logger log = LoggerFactory.getLogger(CityController.class);
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }


 @PostMapping("/insert")
    public String insert(CityVO cityVO) {
     System.out.println(cityVO.toString());
     String result = cityService.insert(cityVO);
     System.out.println("--------->> " + result);
    return "city/insert_result";
 }

@GetMapping("/all")
    public ModelAndView all() {
     List<CityVO> all = cityService.all();
    System.out.println("--------->> " + all);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("all", all);
    modelAndView.setViewName("city/all_result");
    return modelAndView;
}
}
