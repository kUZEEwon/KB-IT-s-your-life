package com.multi.q1;

import com.sun.tools.javac.Main;
import dbcp.DBConnectionMgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DeptListUI {
    public static void main(String[] args) {
        DeptDAO dao = new DeptDAO();

        ArrayList<DeptVO> list = dao.list();

        if (list.size() > 0) {
            for (DeptVO vo : list) {
                System.out.println("검색결과>> deptNo = " + vo.getDeptNo());
                System.out.println("검색결과>> deptName = " + vo.getDeptName());
                System.out.println("검색결과>> Loc = " + vo.getLoc());
                System.out.println("-----------------------------------");
            }
        }else {
            System.out.println("검색결과 없음");
        }
    }

}
