package com.multi.spring3.board.dao;

import com.multi.spring3.board.mapper.BoardMapper;
import com.multi.spring3.member.domain.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAO {
    private final SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public BoardDAO(SqlSessionTemplate sqlSessionTemplate) {
      this.sqlSessionTemplate = sqlSessionTemplate;
  }
    public int insert(BoardVO boardVO) {
        return sqlSessionTemplate.getMapper(BoardMapper.class).insert(boardVO);
    }

    public int update(BoardVO boardVO) {
        return sqlSessionTemplate.getMapper(BoardMapper.class).update(boardVO);
    }

    public int delete(int no) {
        return sqlSessionTemplate.getMapper(BoardMapper.class).delete(no);
    }

    public BoardVO one(int no) { return sqlSessionTemplate.getMapper(BoardMapper.class).one(no);}

    public List<BoardVO> all() { return sqlSessionTemplate.getMapper(BoardMapper.class).all();}
}
