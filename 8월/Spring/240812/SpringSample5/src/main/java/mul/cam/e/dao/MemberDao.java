package mul.cam.e.dao;

import mul.cam.e.dto.MemberDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDao {
    private final SqlSessionTemplate sqlSession; // MyBatis

    @Autowired
    public MemberDao(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<MemberDto> allMember() {
        return sqlSession.selectList("MemberMapper.allMember");
    }


}
