package com.multi.spring4.board.mapper;

import com.multi.spring4.board.domain.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardVO> all();
}
