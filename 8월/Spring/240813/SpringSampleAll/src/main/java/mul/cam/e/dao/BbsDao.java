package mul.cam.e.dao;

import mul.cam.e.dto.BbsDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BbsDao {
    List<BbsDto> bbslist();
    void bbswrite(BbsDto bbsDto);
}
