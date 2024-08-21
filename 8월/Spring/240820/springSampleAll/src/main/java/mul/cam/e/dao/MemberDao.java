package mul.cam.e.dao;

import mul.cam.e.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
@Repository
public class MemberDao {
    private final SqlSessionTemplate sqlSession;    // <- MyBatis

    public MemberDao(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<MemberDto> allMember() {
        return sqlSession.selectList("MemberMapper.allMember");
    }
}
*/

@Mapper
@Repository
public interface MemberDao {
    public int getId(String id);

    public int regiAf(MemberDto memberDto);

    public MemberDto login(MemberDto memberDto);
}


