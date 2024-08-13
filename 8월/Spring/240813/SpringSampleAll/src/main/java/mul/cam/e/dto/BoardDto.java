package mul.cam.e.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardDto {
    private Integer seq;
    private String id;
    private String title;
    private String content;
    private String wdate;
    private Integer del;
    private Integer readcount;
}
