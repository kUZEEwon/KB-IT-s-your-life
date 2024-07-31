package dao;

import db.DBClose;
import db.DBConnection;
import dto.MemberDto;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
    // singleTon으로 만든다. 언제든지 불러서 사용할 수 있도록

    private static MemberDao memberDao = new MemberDao();
    private MemberDao() {
        DBConnection.initConnection();
    }

    public static MemberDao getInstance() {
        return memberDao;
    }

    public MemberDto login(String id, String pw) {
        String sql = "select id,pw,name,email from member where id = ? and pw = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        MemberDto member = null;

        conn = DBConnection.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, pw);
            rs = ps.executeQuery();

            if (rs.next()) {
                member = new MemberDto();
                member.setId(rs.getString("id"));
                member.setPw(rs.getString("pw"));

                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));

            }
        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
            DBClose.close(conn, ps, rs);
        }
        return member;
    }

    public boolean getId(String id){
        String sql = "select count(*) from member where id = ?";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int count = 0;

        try {
            conn = DBConnection.getConnection();
            System.out.println("MemberDao getId Success 1/4");

            ps = conn.prepareCall(sql);
            ps.setString(1, id);
            System.out.println("MemberDao getId Success 2/4");

            rs = ps.executeQuery();
            System.out.println("MemberDao getId Success 3/4");
            if(rs.next()){ // id가 원래 존재하면 들어온다.
               count = rs.getInt(1);
            }
            System.out.println("MemberDao getId Success 4/4");

        } catch (SQLException e) {
            System.out.println("MemberDao getId Failed");
            e.printStackTrace();
        } finally {
            DBClose.close(conn, ps, rs);
        }
        return count > 0?true:false;
    }


    public boolean insertMember(MemberDto member) {
        String sql = "insert into member(id,pw,name,email,auth)" +
                "values(?,?,?,?,3)";
        Connection conn = null;
        PreparedStatement ps = null;
        int count=0;



        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, member.getId());
            ps.setString(2, member.getPw());
            ps.setString(3, member.getName());
            ps.setString(4, member.getEmail());

            count = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, ps, null);
        }
        return count>0?true:false;
    }
}
