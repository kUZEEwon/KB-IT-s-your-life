package mul.cam.e.service;

import mul.cam.e.dao.MemberDao;
import mul.cam.e.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {

    private final MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public SecurityUser findByUsername(String username) {
        return memberDao.findByUsername(username);
    }
}
