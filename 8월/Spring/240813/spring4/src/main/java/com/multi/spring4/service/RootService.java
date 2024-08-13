package com.multi.spring4.service;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
 public class RootService {

    public RootService(){
        System.out.println("RootService created");
    }

    public String check(String userID){
        String[] list = {"root", "admin", "hong"};
        List<String> list2 = Arrays.asList(list);
        String result = "중복이 되지 않아, 사용 가능";
        if (list2.contains(userID)) {
            result = "중복이 되어 사용 불가능";
        }
        return result;
    }

    public int pay(int pay, String choice){
        int money = pay;

        switch (choice) {
            case "1":
                money = money - 1000;
                break;
            case "2":
                money = money + 1000;
                break;
            default:
                break;
        }
        return money;
    }

    public String phone(String phone){
        String result = "";
        String pre = phone.substring(0, 3); // 0~2까지 추출

        switch (pre) {
            case "010":
                result = "100";
                break;
            case "011":
                result = "111";
                break;
            default:
                result = "222";
                break;
        }

        Random r = new Random();
        int post = r.nextInt(900) + 100; // 100~999 (0~899 + 100)
        result = result + post;
        return result;
    }


}