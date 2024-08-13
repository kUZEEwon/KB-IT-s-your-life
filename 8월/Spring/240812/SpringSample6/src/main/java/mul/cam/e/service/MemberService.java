package mul.cam.e.service;

import mul.cam.e.dao.MemberDao;
import mul.cam.e.dto.MemberDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public List<MemberDto> allMember() {
        return memberDao.allMember();
    }
}
