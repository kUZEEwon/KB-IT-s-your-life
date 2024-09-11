package mul.cam.e.service;

import mul.cam.e.dao.MemberDao;
import mul.cam.e.security.SecurityUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {

    private final MemberDao dao;

    public MemberService(MemberDao dao) {
        this.dao = dao;
    }

    public boolean idCheck(String username) {
        return dao.idCheck(username) > 0;
    }

    public boolean regi(SecurityUser user){
        return dao.regi(user) > 0;
    }

    public SecurityUser login(String username) {
        return dao.login(username);
    }
}







