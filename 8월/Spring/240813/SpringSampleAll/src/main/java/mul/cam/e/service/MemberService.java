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

    public List<MemberDto> allMember(){
        return memberDao.allMember();
    }

    public boolean getId(String id){
        int cnt= memberDao.getId(id);
        return cnt>0;
    }

    public int login(MemberDto memberDto) {
        return memberDao.login(memberDto);
    }

    public boolean regi(MemberDto memberDto) {
        int count = memberDao.regi(memberDto);
        return count>0;
    }
}
