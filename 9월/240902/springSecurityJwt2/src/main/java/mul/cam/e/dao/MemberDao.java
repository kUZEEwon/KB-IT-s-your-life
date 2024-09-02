package mul.cam.e.dao;

import mul.cam.e.security.SecurityUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberDao {

    SecurityUser findByUsername(String username); // get member

}
