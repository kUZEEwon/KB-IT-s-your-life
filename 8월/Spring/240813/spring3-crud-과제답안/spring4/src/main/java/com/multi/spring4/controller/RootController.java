package com.multi.spring4.controller;

import com.multi.spring4.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
 public class RootController {

    private RootService rootService;

    public RootController(){
        System.out.println("RootController created");
    }

    @Autowired
    public RootController(RootService rootService){
        this.rootService = rootService;
    }

    @GetMapping("/")
    public String root(){
        return "index";
    }


    @GetMapping("/data")
    @ResponseBody
    public String data(){
        return "data ok";
    }

    @GetMapping("/food")
    @ResponseBody
    public String food(){
        return "선릉역 주변 맛집 : 피그인, 스노우도그";
    }

    @GetMapping("/weather")
    @ResponseBody
    public String weather(){
        return "비올 확률 60%, 온도 35도, 더움";
    }

    @GetMapping("/check")
    @ResponseBody
    public String check(String userId){
        return rootService.check(userId);
    }

    @GetMapping("/phone")
    @ResponseBody
    public String phone(@RequestParam("phoneNumber") String phone){
        return rootService.phone(phone);
    }

    @PostMapping("/pay")
    public ModelAndView pay(@RequestParam("amount") int pay,
                      @RequestParam("choice") String choice){
        int result = rootService.pay(pay, choice);
        ModelAndView modelAndView = new ModelAndView("pay");
        modelAndView.addObject("result", result);
        return modelAndView;
    }
}