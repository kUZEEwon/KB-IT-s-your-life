package dao;

import db.DBClose;
import db.DBConnection;
import dto.BbsDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BbsDao {

    private static BbsDao bbsDao = new BbsDao();

    private BbsDao() {
    }

    public static BbsDao getInstance() {
        return bbsDao;
    }

    public List<BbsDto> getBbslist(){
        String sql = " select seq, id, title, content, wdate, del, readcount " +
                "      from bbs " +
                "      order by wdate desc ";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        List<BbsDto> list = new ArrayList<BbsDto>();

        try {
            conn = DBConnection.getConnection();
            System.out.println("BbsDao getBbslist 1/4 success");

            psmt = conn.prepareStatement(sql);
            System.out.println("BbsDao getBbslist 2/4 success");

            rs = psmt.executeQuery();
            System.out.println("BbsDao getBbslist 3/4 success");

            while (rs.next()) {
                int seq = rs.getInt("seq");
                String id = rs.getString("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String wdate = rs.getString("wdate");
                int del = rs.getInt("del");
                int readcount = rs.getInt("readcount");

                BbsDto dto = new BbsDto(seq, id, title, content, wdate, del, readcount);
                list.add(dto);
            }
            System.out.println("BbsDao getBbslist 4/4 success");

        } catch (SQLException e) {
            System.out.println("BbsDao getBbslist fail");
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, rs);
        }

        return list;
    }

    public List<BbsDto> getBbsSearchlist(String category, String keyword){
        String sql = " select seq, id, title, content, wdate, del, readcount " +
                "      from bbs ";

        // 검색
        if(category.equals("title")){
            sql += " where title like '%"+keyword+"%' ";
        }else if(category.equals("content")){
            sql += " where content like '%"+keyword+"%' ";
        }else if(category.equals("writer")){
            sql += " where id = '"+keyword+"' ";
        }

        sql += "      order by wdate desc ";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        List<BbsDto> list = new ArrayList<BbsDto>();

        try {
            conn = DBConnection.getConnection();
            System.out.println("BbsDao getBbslist 1/4 success");

            psmt = conn.prepareStatement(sql);
            System.out.println("BbsDao getBbslist 2/4 success");

            rs = psmt.executeQuery();
            System.out.println("BbsDao getBbslist 3/4 success");

            while (rs.next()) {
                int seq = rs.getInt("seq");
                String id = rs.getString("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String wdate = rs.getString("wdate");
                int del = rs.getInt("del");
                int readcount = rs.getInt("readcount");

                BbsDto dto = new BbsDto(seq, id, title, content, wdate, del, readcount);
                list.add(dto);
            }
            System.out.println("BbsDao getBbslist 4/4 success");

        } catch (SQLException e) {
            System.out.println("BbsDao getBbslist fail");
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, rs);
        }

        return list;
    }

    public boolean bbswrite(BbsDto dto) {
        String sql = " insert into bbs(id, title, content, wdate, del, readcount) " +
                "      values(?, ?, ?, now(), 0, 0) ";

        Connection conn = null;
        PreparedStatement psmt = null;

        int count = 0;

        try {
            conn = DBConnection.getConnection();

            psmt = conn.prepareStatement(sql);
            psmt.setString(1, dto.getId());
            psmt.setString(2, dto.getTitle());
            psmt.setString(3, dto.getContent());

            count = psmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("BbsDao bbswrite fail");
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, null);
        }

        return count>0?true:false;
    }

    public BbsDto getBbs(int seq) {
        String sql = "  select * " +
                "       from bbs " +
                "       where seq = ? ";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        BbsDto dto = null;

        try {
            conn = DBConnection.getConnection();

            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, seq);

            rs = psmt.executeQuery();
            if (rs.next()) {
                dto = new BbsDto();
                dto.setId(rs.getString("id"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setWdate(rs.getString("wdate"));
                dto.setDel(rs.getInt("del"));
                dto.setReadcount(rs.getInt("readcount"));
            }

        } catch (SQLException e) {
            System.out.println("BbsDao getBbs fail");
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, rs);
        }

        return dto;
    }

}




