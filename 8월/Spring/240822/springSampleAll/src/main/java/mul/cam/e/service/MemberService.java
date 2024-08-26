package mul.cam.e.service;

import mul.cam.e.dao.MemberDao;
import mul.cam.e.dto.MemberDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberService {

    private final MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public boolean getId(String id){
        int count = memberDao.getId(id);
        return count>0?true:false;
    }

    public boolean regiAf(MemberDto memberDto){
        int count = memberDao.regiAf(memberDto);
        return count > 0;
    }

    public MemberDto login(MemberDto memberDto){
        return memberDao.login(memberDto);
    }

}
