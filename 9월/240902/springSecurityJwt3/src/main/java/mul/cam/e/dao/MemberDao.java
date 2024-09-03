package mul.cam.e.dao;

import mul.cam.e.security.SecurityUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberDao {
    int idCheck(String username);

    // insert의 리턴은 무조건 int
    int regi(SecurityUser user);

    SecurityUser login(String username);
}
