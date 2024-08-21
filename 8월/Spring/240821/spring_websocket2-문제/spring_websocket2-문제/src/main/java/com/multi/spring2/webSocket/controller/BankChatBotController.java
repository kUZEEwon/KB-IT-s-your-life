package com.multi.spring2.webSocket.controller;

import com.multi.spring2.webSocket.domain.Message;
import com.multi.spring2.webSocket.domain.OutputMessage;
import com.multi.spring2.webSocket.domain.OutputMessage2;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BankChatBotController {


    @MessageMapping("/chat2")
    @SendTo("/topic/messages2")
    public OutputMessage2 send2(Message message) {
        System.out.println("받은 데이터>>" + message);
        OutputMessage2 out = new OutputMessage2();
        String menu = "";


        //챗봇 시나리오
        switch (message.getText()) {
            case "1":
                menu = "챗 봇>> 10) 잔액조회 11) 계좌이체 12) 거래내역 조회";
                break;
            case "2":
                menu = "챗 봇>> 20) 대출상품 안내 21) 예적금 상품 안내";
                break;
            case "10":
                menu = "챗 봇>> 잔액조회 중입니다. 계좌번호를 입력하세요. (예: 10-123-456-7890)";
                break;
            case "10-123-456-7890":
                menu ="챗 봇>> 입력하신 계좌의 잔액은 1,500,000원 입니다.";
                break;
            case "11":
                menu = "챗 봇>> 계좌이체를 진행합니다. 출금 계좌번호를 입력해주세요. (예: 123-456-7890)";
                break;
            case "123-456-7890":
                menu = "챗 봇>> 입금 계좌번호를 입력해주세요. (예: 098-765-4321)";
                break;
            case "098-765-4321":
               menu = "이체 금액을 입력해주세요.(50000)";
               break;
            case "50000":
                menu = "50,000이 계좌 098-765-4321로 이체 되었습니다.";
                break;
            case "12":
                menu = "챗 봇>> 거래내역 조회 중입니다. 계좌번호를 입력해주세요.";
                break;
            case "20":
                menu = "챗 봇>> 대출 상품 목록 20-1) 주택담보대출 - 이자율: 2.5% 20-2) 신용대출 - 이자율: 3.0% 대출 종류를 선택해주세요. (예: 20-1)";
                break;
            case "20-1":
                menu = "챗 봇>> 주택담보대출 상품을 선택하셨습니다. 대출 한도는 최대 5억 원, 상환 기간은 최대 30년입니다. 상담을 원하시면 1번을 입력하세요.";
                break;
            case "20-2":
                menu = "챗 봇>> 신용대출 상품을 선택하셨습니다. 대출 한도는 최대 1억 원, 상환 기간은 최대 10년입니다. 상담을 원하시면 1번을 입력하세요.";
                break;
            case "21":
                menu = "챗 봇>> 예적금 상품 목록 21-1) 정기예금 - 이율: 1.5% 21-2) 자유적금 - 이율: 1.7% 예적금 상품을 선택해주세요. (예: 21-1)";
                break;
            case "21-1":
                menu = "챗 봇>> 정기예금을 선택하셨습니다. 이 상품의 최소 가입 금액은 100만원이며, 이율은 1.5%입니다.";
                break;
            case "21-2":
                menu = "챗 봇>> 자유적금을 선택하셨습니다. 월 최소 납입액은 10만 원이며, 언제든지 납입 및 인출이 가능합니다.";
                break;
            default:
                menu = "챗 봇>> 선택한 번호는 없는 메뉴입니다. 다시 입력해주세요.";
                break;
        }


        out.setMenu(menu);
        return out;
    }

    @MessageMapping("/chat") //채팅 내용 받을 때 사용하는 주소
    @SendTo("/topic/messages") //가입주소한 브라우저에 return message를 json으로 변환해서 보내줌.
    public OutputMessage send(Message message) {
        System.out.println("받은 데이터>>" + message);
        OutputMessage out = new OutputMessage();
        out.setFrom(message.getFrom());
        out.setText(message.getText());
        Date date = new Date();
        out.setTime(date.getHours() + ":" + date.getMinutes());
        return out;
    }
}