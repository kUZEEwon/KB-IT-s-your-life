package com.multi.q1;

import java.util.Scanner;

public class DeptOneUI {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("deptNo>>  ");
            String deptNo = sc.next();

            DeptDAO dao = new DeptDAO();
            DeptVO vo = dao.one(deptNo);
            if(vo != null){
                System.out.println("검색결과>> deptNo = " + vo.getDeptNo());
                System.out.println("검색결과>> deptName = " + vo.getDeptName());
                System.out.println("검색결과>> Loc = " + vo.getLoc());
            }
            else {
                System.out.println("검색결과 없음");
            }
            sc.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
