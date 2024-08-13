package mul.cam.e.dao;

import mul.cam.e.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardDao {
    List<BoardDto> all();
}
