package dao;

import db.DBClose;
import db.DBConnection;
import dto.BbsDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BbsDao {

    private static BbsDao bbsDao = new BbsDao();

    private BbsDao() {
    }

    public static BbsDao getInstance() {
        return bbsDao;
    }

    public void increReadCount(int seq) {
        String sql = "update bbs set readcount = readcount + 1 where seq = ?";
        System.out.println(sql);
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, seq);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating read count: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 데이터베이스 자원 반환
            DBClose.close(conn, pstmt, null);
        }

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
                dto.setSeq(rs.getInt("seq"));
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


    public boolean updateBbs(int seq, String title, String content) {
        String sql = "UPDATE bbs SET " +
                "title = ?, " +
                "content = ?, " +
                "wdate = now() " + // 현재 날짜와 시간은 SQL에서 직접 처리
                "WHERE seq = ?";

        Connection conn = null;
        PreparedStatement psmt = null;

        boolean isUpdated = false;

        try {
            conn = DBConnection.getConnection();
            psmt = conn.prepareStatement(sql);

            // SQL 파라미터 설정
            psmt.setString(1, title); // 제목
            psmt.setString(2, content); // 내용
            psmt.setInt(3, seq); // 게시글 번호

            int rowsAffected = psmt.executeUpdate();

            if (rowsAffected > 0) {
                isUpdated = true; // 업데이트 성공
            }

        } catch (SQLException e) {
            System.out.println("BbsDao updateBbs fail");
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, null);
        }

        return isUpdated;
    }

}




