package dao;

import db.DBClose;
import db.DBConnection;
import dto.MemberDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {

    private static MemberDao memberDao = new MemberDao();

    private MemberDao() {
        DBConnection.initConnection();
    }

    public static MemberDao getInstance() {
        return memberDao;
    }

    public boolean insertMember(MemberDto member) {

        String sql = " insert into member(id, pw, name, email, auth) "
                +    " values(?, ?, ?, ?, 3) ";

        Connection conn = null;
        PreparedStatement psmt = null;
        int count = 0;

        try {
            conn = DBConnection.getConnection();

            psmt = conn.prepareStatement(sql);
            psmt.setString(1, member.getId());
            psmt.setString(2, member.getPw());
            psmt.setString(3, member.getName());
            psmt.setString(4, member.getEmail());

            count = psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, null);
        }

        return count>0?true:false;
    }

    public boolean getId(String id){
        String sql = " select count(*) " +
                "      from member " +
                "      where id = ? ";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        int count = 0;

        try {
            conn = DBConnection.getConnection();
            System.out.println("MemberDao getId success 1/4");

            psmt = conn.prepareStatement(sql);
            psmt.setString(1, id);
            System.out.println("MemberDao getId success 2/4");

            rs = psmt.executeQuery();
            System.out.println("MemberDao getId success 3/4");

            if(rs.next()){  // 있으면 조건으로 들어온다
                count = rs.getInt(1);
            }
            System.out.println("MemberDao getId success 4/4");

        } catch (SQLException e) {
            System.out.println("MemberDao getId fail");
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, rs);
        }

        return count>0?true:false;
    }

    public MemberDto login(String id, String pw) {
        String sql = "  select id, pw, name, email " +
                "       from member " +
                "       where id = ? and pw = ? ";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        MemberDto member = null;

        try {
            conn = DBConnection.getConnection();

            psmt = conn.prepareStatement(sql);
            psmt.setString(1, id);
            psmt.setString(2, pw);

            rs = psmt.executeQuery();

            if(rs.next()){
                member = new MemberDto();
                member.setId(rs.getString("id"));
                member.setPw(rs.getString("pw"));
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, rs);
        }

        return member;
    }


}










