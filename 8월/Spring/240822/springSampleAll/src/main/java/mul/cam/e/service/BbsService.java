package mul.cam.e.service;

import mul.cam.e.dao.BbsDao;

import mul.cam.e.dto.BbsComment;
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
    public boolean bbsupdate(BbsDto bbsDto){
        int n = bbsDao.bbsupdate(bbsDto);
        return n>0?true:false;
    }

    public boolean bbsanswer(BbsDto bbsDto){
        bbsDao.bbsanswerUpdate(bbsDto);
        int n = bbsDao.bbsanswerInsert(bbsDto);
        return n>0?true:false;
    }

    public boolean commentWrite(BbsComment comment){
        return bbsDao.commentWrite(comment)>0?true:false;
    }

    public List<BbsComment> commentList(int seq){
        return bbsDao.commentList(seq);
    }

}






