package mul.cam.e.service;

import mul.cam.e.dao.BbsDao;
import mul.cam.e.dto.BbsDto;
import mul.cam.e.dto.BbsParam;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BbsService {

    private final BbsDao dao;

    public BbsService(BbsDao dao) {
        this.dao = dao;
    }

    public List<BbsDto> bbsList(BbsParam param){
        return dao.bbsList(param);
    }

    public int allBbs(BbsParam param){
        return dao.allBbs(param);
    }

    public int bbsWrite(BbsDto bbs) {
        return dao.bbsWrite(bbs);
    }

    public BbsDto bbsDetail(BbsDto bbs) {
        return dao.bbsDetail(bbs);
    }

    public int bbsAnswer(BbsDto bbs) {
        dao.bbsAnswerUpdate(bbs);
        return dao.bbsAnswerInsert(bbs);
    }

    public int bbsUpdate(BbsDto bbs) {
        return dao.bbsUpdate(bbs);
    }
}
