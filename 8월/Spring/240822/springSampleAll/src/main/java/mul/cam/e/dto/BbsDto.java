package mul.cam.e.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BbsDto {
    private int seq;
    private String id;

    private int ref;    // 답글용
    private int step;
    private int depth;

    private String title;
    private String content;
    private String wdate;

    private int del;
    private int readcount;
}
