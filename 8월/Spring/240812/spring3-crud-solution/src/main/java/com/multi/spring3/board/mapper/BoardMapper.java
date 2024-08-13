package com.multi.spring3.board.mapper;

import com.multi.spring3.board.domain.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BoardMapper {
  //mapper의 id와 맞아야함.
  int insert(BoardVO boardVO); //<insert id="insert" ~~>
  int delete(int no);
  int update(BoardVO boardVO);

}