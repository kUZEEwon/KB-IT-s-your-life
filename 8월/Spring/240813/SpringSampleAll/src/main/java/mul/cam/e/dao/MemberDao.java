package mul.cam.e.dao;

import mul.cam.e.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MemberDao {
    public List<MemberDto> allMember();

    public int login(MemberDto memberDto);

    int regi(MemberDto memberDto);

    public int getId(String id);
}
