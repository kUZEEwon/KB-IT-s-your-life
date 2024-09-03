package mul.cam.e.service;

import mul.cam.e.dao.MemberDao;
import mul.cam.e.security.SecurityUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {
    private final MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public boolean idCheck(String username) {
        return memberDao.idCheck(username) > 0 ;
    }

    public boolean regi(SecurityUser user){
        return memberDao.regi(user) > 0;
    }

    public SecurityUser login(String username) {
        return memberDao.login(username);
    }
}
