package mul.cam.e.service;

import mul.cam.e.dao.BbsDao;
import mul.cam.e.dto.BbsDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BbsService {

    private final BbsDao bbsDao;

    public BbsService(BbsDao boardDao) {
        this.bbsDao = boardDao;
    }

    public List<BbsDto> bbslist() {
        return bbsDao.bbslist();
    }

    public void bbswrite(BbsDto bbs) {
        bbsDao.bbswrite(bbs);
    }
}
