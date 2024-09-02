package mul.cam.e.dao;

import mul.cam.e.model.CustomUserDetails;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestMapping;

@Mapper
@RequestMapping
public interface UserDao {

    CustomUserDetails findByUsername(String username);
}
