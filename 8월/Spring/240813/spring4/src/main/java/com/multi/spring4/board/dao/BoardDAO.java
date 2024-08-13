package com.multi.spring4.board.dao;

import com.multi.spring4.board.domain.BoardVO;
import com.multi.spring4.board.mapper.BoardMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAO {

    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public BoardDAO(SqlSessionTemplate sqlSessionTemplate){
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<BoardVO> all() {
        return sqlSessionTemplate.getMapper(BoardMapper.class).all();
    }
    /*
    use shop2;
    CREATE TABLE `board` (
      `no` int NOT NULL AUTO_INCREMENT,
      `title` varchar(45) NOT NULL,
      `content` varchar(45) NOT NULL,
      `writer` varchar(45) NOT NULL,
      PRIMARY KEY (`no`)
    ) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

    SELECT * FROM shop2.board;

    insert into board values
    (null, 'good1', 'fun job', 'apple'),
    (null, 'good2', 'fun job', 'apple'),
    (null, 'good3', 'fun job', 'apple2'),
    (null, 'good4', 'fun job', 'apple2'),
    (null, 'good5', 'fun job', 'apple2'),
    (null, 'good6', 'fun job', 'apple3'),
    (null, 'good7', 'fun job', 'apple3'),
    (null, 'good8', 'fun job', 'apple3'),
    (null, 'good9', 'fun job', 'apple4'),
    (null, 'good10', 'fun job', 'apple4'),
    (null, 'good11', 'fun job', 'apple4'),
    (null, 'good12', 'fun job', 'apple3'),
    (null, 'good13', 'fun job', 'apple3'),
    (null, 'good14', 'fun job', 'apple4'),
    (null, 'good15', 'fun job', 'apple4');

     */

}

