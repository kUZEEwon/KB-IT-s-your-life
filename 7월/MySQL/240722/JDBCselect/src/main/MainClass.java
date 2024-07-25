package main;
import dao.UserDao;
import dto.UserDto;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

import static java.time.LocalTime.now;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserDao dao = new UserDao();

       /* String id = "abc";
        UserDto user= dao.getUser(id);
        System.out.println(user.toString());*/
/*
        List<UserDto> users = dao.getAllUsers();
        for (UserDto user : users) {
            System.out.println(user);
           System.out.println(user.getId());
            System.out.println(user.getName());
            System.out.println(user.getAge());
            System.out.println(user.getJoindate());
            System.out.println("-------------------");
        }*/
        // insert
        System.out.println("데이터 추가");
        System.out.println("id를 입력하세요 : ");
        String id = sc.next();

        System.out.println("이름을 입력하세요 : ");
        String name = sc.next();

        System.out.println("나이를 입력하세요 : ");
        int age = sc.nextInt();
        UserDto insertData = new UserDto(id,name,age, "now()");
        System.out.println("추가할 데이터 입니다 \n" + insertData);
        int insertCnt= dao.UserInsert(insertData);
        System.out.println("insertCnt: "+insertCnt);

        // delete
        /*String id = "abc";
        UserDto user= dao.getUser(id);
        int deleteCnt = dao.UserDelete(user);
        System.out.println("deleteCnt: "+deleteCnt);*/

        // update
       /* String id = "abc";
        UserDto user= dao.getUser(id);
        System.out.println(user.toString());

        int updateCnt = dao.UserUpdate(user);
        System.out.println("updateCnt : " + updateCnt);*/

    }
}
