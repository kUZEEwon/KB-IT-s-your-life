package mul.cam.e.service;

import mul.cam.e.dao.BbsDao;

import mul.cam.e.dto.BbsDto;
import mul.cam.e.dto.BbsPram;
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

    public List<BbsDto> bbslist(BbsPram param){
        return bbsDao.bbslist(param);
    }

    public boolean bbswrite(BbsDto bbsDto){
        int n=bbsDao.bbswrite(bbsDto);
        return n>0 ? true : false;
    }

    public int getTotalBbs(BbsPram param){
        return bbsDao.getTotalBbs(param);
    }
}
