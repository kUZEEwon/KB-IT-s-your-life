package mul.cam.e.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private String id;
    private String pw;
    private String name;
    private String email;
    private int auth;
}
