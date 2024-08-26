package mul.cam.e.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BbsComment implements Serializable {
    private int seq;
    private String id;
    private String content;
    private String wdate;
}
