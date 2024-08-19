package mul.cam.e.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BbsDto {
    private Integer seq;
    private String id;
    // 답글용
    private Integer ref;       // group번호 추가
    private Integer step;      // 행 번호 추가
    private Integer depth;     // 깊이 번호 추가

    private String title;
    private String content;
    private String wdate; // 또는 java.util.Date
    private Integer del;
    private Integer readcount;
}
