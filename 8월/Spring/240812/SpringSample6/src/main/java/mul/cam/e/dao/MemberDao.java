package mul.cam.e.dao;

import mul.cam.e.dto.MemberDto;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.lang.reflect.Member;

@Repository
public class MemberDao {
    private final SqlSessionTemplate sqlSession;


    public MemberDao(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<MemberDto> allMember() {
        return sqlSession.selectList("MemberMapper.allMember");
    }
}
