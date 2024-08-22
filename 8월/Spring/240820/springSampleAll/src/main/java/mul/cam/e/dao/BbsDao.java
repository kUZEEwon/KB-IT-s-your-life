package mul.cam.e.dao;

import mul.cam.e.dto.BbsCommentDto;
import mul.cam.e.dto.BbsDto;
import mul.cam.e.dto.BbsParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BbsDao {

    List<BbsDto> bbslist(BbsParam param);
    int getTotalBbs(BbsParam param);

    int bbswrite(BbsDto bbsDto);

    BbsDto bbsdetail(int seq);
    int bbsdelete(int seq);
    int bbsupdate(BbsDto bbsDto);

    int bbsanswerUpdate(BbsDto bbsDto);
    int bbsanswerInsert(BbsDto bbsDto);

    int bbscommentInsert(BbsCommentDto dto);
    List<BbsCommentDto> bbscommentAll(int bbsSeq);
    int bbscommentUpdate(BbsCommentDto dto);
    int bbscommentDelete(BbsCommentDto dto);
}
