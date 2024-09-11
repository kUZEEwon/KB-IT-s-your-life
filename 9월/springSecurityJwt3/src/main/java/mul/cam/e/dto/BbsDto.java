package mul.cam.e.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class BbsDto implements Serializable {
    private int seq;		// sequence 글번호
    private String username;		// 작성자

    private int ref;		// 그룹번호(글번호)
    private int step;		// 행번호
    private int depth;		// 깊이

    private String title;
    private String content;
    private String wdate;

    private int del;
    private int readcount;	// 조회수
}
