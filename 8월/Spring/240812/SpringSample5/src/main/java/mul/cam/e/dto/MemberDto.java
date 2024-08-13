package mul.cam.e.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberDto {
    private String id;
    private String pw;
    private String name;
    private String email;
    private int auth;
}
