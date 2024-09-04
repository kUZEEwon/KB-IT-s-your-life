package mul.cam.e.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class BbsParam implements Serializable {
    private String category;
    private String keyword;
    private int pageNumber;
}
