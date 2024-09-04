package mul.cam.e.dao;

import mul.cam.e.dto.BbsDto;
import mul.cam.e.dto.BbsParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BbsDao {

    List<BbsDto> bbsList(BbsParam param);
    int allBbs(BbsParam param);

    int bbsWrite(BbsDto bbs);
    BbsDto bbsDetail(BbsDto bbs);

    void bbsAnswerUpdate(BbsDto bbs);
    int bbsAnswerInsert(BbsDto bbs);

    int bbsUpdate(BbsDto bbs);

}
