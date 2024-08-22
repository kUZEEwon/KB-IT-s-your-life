package mul.cam.e.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BbsCommentDto {
    private int seq;
    private int bbsSeq;
    private String id;
    private String wdate;
    private String comment;
}
