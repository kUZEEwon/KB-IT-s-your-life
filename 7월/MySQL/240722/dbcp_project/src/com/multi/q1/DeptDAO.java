package com.multi.q1;

import dbcp.DBConnectionMgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DeptDAO {
    DBConnectionMgr dbcp = null;
    Connection con = null;
    public DeptDAO(){
        dbcp = new DBConnectionMgr();
    }

    public DeptVO one(String deptno){
        DeptVO dept = new DeptVO();

        try {
            con = dbcp.getConnection();

            String sql = "select * from dept where DEPTNO = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(deptno));
            System.out.println("3. sql 부품(객체)로 만들어주기 성공");
            ResultSet result = ps.executeQuery();
            System.out.println("4. SQL문 MYSQL 로 보내기 성공");

            if(result.next()){
                dept = new DeptVO();
                dept.setDeptNo(result.getInt(1));
                dept.setDeptName(result.getString(2));
                dept.setLoc(result.getString(3));

            }
            con.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dept;
    }


    public ArrayList<DeptVO> list(){
        ArrayList<DeptVO> list = new ArrayList<>();


        try {
            con = dbcp.getConnection();

            String sql = "select * from dept where DEPTNO";
            PreparedStatement ps = con.prepareStatement(sql);

            //  System.out.println("3. sql 부품(객체)로 만들어주기 성공");
            ResultSet result = ps.executeQuery();
            // System.out.println("4. SQL문 MYSQL 로 보내기 성공");

            while(result.next()){
                DeptVO dept = new DeptVO();

                dept.setDeptNo(result.getInt(1));
                dept.setDeptName(result.getString(2));
                dept.setLoc(result.getString(3));
                list.add(dept);
            }
            con.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
