package mul.cam.e.service;

import mul.cam.e.dao.BbsDao;

import mul.cam.e.dto.BbsCommentDto;
import mul.cam.e.dto.BbsDto;
import mul.cam.e.dto.BbsParam;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BbsService {

    private final BbsDao bbsDao;

    public BbsService(BbsDao bbsDao) {
        this.bbsDao = bbsDao;
    }

    public List<BbsDto> bbslist(BbsParam param){
        return bbsDao.bbslist(param);
    }

    public int getTotalBbs(BbsParam param){
        return bbsDao.getTotalBbs(param);
    }

    public boolean bbswrite(BbsDto bbsDto){
        int n = bbsDao.bbswrite(bbsDto);
        return n>0?true:false;
    }

    public BbsDto bbsdetail(int seq){
        return bbsDao.bbsdetail(seq);
    }

    public int bbsdelete(int seq) {
        return bbsDao.bbsdelete(seq);  // 삭제된 행의 개수를 반환
    }

    public int bbsupdate(BbsDto bbsDto) {
        return bbsDao.bbsupdate(bbsDto);
    }

    public boolean bbsanswer(BbsDto dto)
    {
        bbsDao.bbsanswerUpdate(dto);
        int n = bbsDao.bbsanswerInsert(dto);

        return n>0?true:false;
    }

    public boolean bbscommentInsert(BbsCommentDto dto){
        int n = bbsDao.bbscommentInsert(dto);
        return n>0?true:false;
    }

    public List<BbsCommentDto> bbscommentAll(int bbsSeq)
    {
        return bbsDao.bbscommentAll(bbsSeq);
    }

    public boolean bbscommentUpdate(BbsCommentDto dto){
        int n = bbsDao.bbscommentUpdate(dto);
        return n>0?true:false;
    }

    public boolean bbscommentDelete(BbsCommentDto dto){
        int n = bbsDao.bbscommentDelete(dto);
        return n>0?true:false;
    }
}
