package mul.cam.e.service;

import mul.cam.e.dao.BoardDao;
import mul.cam.e.dto.BoardDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BoardService {
    private final BoardDao boardDao;

    public BoardService(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    public List<BoardDto> all() {
        return boardDao.all();
    }
}
